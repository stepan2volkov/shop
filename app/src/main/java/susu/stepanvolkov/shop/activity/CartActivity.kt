package susu.stepanvolkov.shop.activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.activity.adapter.CartOrderListAdapter
import susu.stepanvolkov.shop.presenter.CartPresenter
import susu.stepanvolkov.shop.presenter.view.CartView

class CartActivity : AppCompatActivity(), CartView {

    private val presenter = CartPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        toolbar.headerText.text = getString(R.string.cart_header)
        toolbar.headerBackBtn.setOnClickListener{ finish() }
        toolbar.shoppingCartBtn.visibility = View.GONE

        presenter.attachView(this)
        presenter.showCartTotals()

        checkoutOrderBtn.setOnClickListener{
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        orderList.layoutManager = LinearLayoutManager(this)
        orderList.adapter = CartOrderListAdapter(presenter.getProducts())
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
}
