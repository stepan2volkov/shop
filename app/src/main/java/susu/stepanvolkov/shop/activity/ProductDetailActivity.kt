package susu.stepanvolkov.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import android.view.View
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import moxy.MvpAppCompatActivity
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.presenter.ProductDetailPresenter
import susu.stepanvolkov.shop.presenter.view.ProductDetailView

class ProductDetailActivity : MvpAppCompatActivity(), ProductDetailView {

    private val presenter = ProductDetailPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        toolbar.headerText.text = ""
        toolbar.headerBackBtn.setOnClickListener{ finish() }
        toolbar.shoppingCartBtn.visibility = View.GONE

        presenter.attachView(this)

        val id = intent.getIntExtra(CatalogActivity.PRODUCT_ID, 0)
        presenter.setProductDetails(id)
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
}
