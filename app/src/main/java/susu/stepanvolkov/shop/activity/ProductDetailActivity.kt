package susu.stepanvolkov.shop.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import android.view.View
import androidx.annotation.RequiresApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import susu.stepanvolkov.shop.App
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.model.CartProductDAO
import susu.stepanvolkov.shop.model.CartProductDAOImpl
import susu.stepanvolkov.shop.presenter.ProductDetailPresenter
import susu.stepanvolkov.shop.presenter.view.ProductDetailView
import javax.inject.Inject

class ProductDetailActivity : MvpAppCompatActivity(), ProductDetailView {

    @Inject
    lateinit var  productDetailPresenter: ProductDetailPresenter
    private val presenter by moxyPresenter { productDetailPresenter }

    private lateinit var cart: CartProductDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

//        cart = CartProductDAOImpl(sharedPreferences)
        toolbar.headerText.text = ""
        toolbar.headerBackBtn.setOnClickListener{ finish() }
        toolbar.shoppingCartBtn.visibility = View.GONE

        presenter.attachView(this)

        val id = intent.getIntExtra(CatalogActivity.PRODUCT_ID, 0)
        presenter.setProductDetails(id)
        addToCartBtn.setOnClickListener {presenter.onAddToCart(id) }
    }

    override fun showProductName(name: String) {
        productName.text = name
    }

    override fun showProductPrice(price: String, priceWithDiscount: String) {
        if (price==priceWithDiscount) {
            productPrice.text = price
        } else {
            val sp = SpannableStringBuilder("$price $priceWithDiscount")
            sp.setSpan(StrikethroughSpan(), 0, price.length, SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE)
            productPrice.text = sp
        }
    }

    override fun showProductDescription(description: String) {
        productDescription.text = description
    }

    override fun setImage(url: String) {
        if (url!="") Picasso.get().load(url).into( productImage)
    }

    override fun changeBtn() {
        addToCartBtn.text = "В корзину"
        addToCartBtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }
}
