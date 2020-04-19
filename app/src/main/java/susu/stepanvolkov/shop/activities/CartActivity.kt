package susu.stepanvolkov.shop.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_cart.view.*
import kotlinx.android.synthetic.main.activity_cart.view.checkoutOrderBtn
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import susu.stepanvolkov.shop.R

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        toolbar.headerText.text = getString(R.string.cart_header)
        toolbar.headerBackBtn.setOnClickListener{ finish() }
        toolbar.shoppingCartBtn.visibility = View.GONE
        checkoutOrderBtn.setOnClickListener{
            // TODO: Переход к CheckoutActivity
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }
}
