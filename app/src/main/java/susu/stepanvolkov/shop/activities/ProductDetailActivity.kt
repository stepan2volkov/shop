package susu.stepanvolkov.shop.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import susu.stepanvolkov.shop.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        toolbar.headerText.text = getString(R.string.checkout_header)
        toolbar.headerBackBtn.setOnClickListener{ finish() }
//        toolbar.shoppingCartBtn.visibility = View.GONE
    }
}
