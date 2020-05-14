package susu.stepanvolkov.shop.activity


import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.activity.adapter.CartOrderListAdapter
import susu.stepanvolkov.shop.model.CartProductDAOImpl
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.presenter.CartPresenter
import susu.stepanvolkov.shop.presenter.view.CartView

class CartActivity : MvpAppCompatActivity(), CartView {

    private val presenter by moxyPresenter { CartPresenter(CartProductDAOImpl(sharedPreferences)) }
    private val adapter = CartOrderListAdapter { p -> presenter.removeItem(p) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        toolbar.headerText.text = getString(R.string.cart_header)
        toolbar.headerBackBtn.setOnClickListener{ finish() }
        toolbar.shoppingCartBtn.visibility = View.GONE

        presenter.attachView(this)

        checkoutOrderBtn.setOnClickListener{
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        orderList.layoutManager = LinearLayoutManager(this)
        orderList.adapter = adapter

        presenter.setData()
    }

    override fun showTotalPrice(price: String) {
        fullPrice.text = price
    }

    override fun showDiscount(discountPrice: String) {
        discount.text = discountPrice
    }

    override fun showPriceWithDiscount(price: String) {
        priceWithDiscount.text = price
    }

    override fun setProducts(products: MutableList<Product>) {
        adapter.setData(products)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun insertItem(position: Int) {
        adapter.notifyItemInserted(position)
    }
}

val MvpAppCompatActivity.sharedPreferences: SharedPreferences
    get() = getSharedPreferences("data", MODE_PRIVATE)