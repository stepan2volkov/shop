package susu.stepanvolkov.shop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_catalog.*
import kotlinx.android.synthetic.main.activity_checkout.toolbar
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import susu.stepanvolkov.shop.R

class CatalogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        /* Toolbar initialization */
        toolbar.headerText.text = getString(R.string.catalog_header)
        toolbar.headerBackBtn.visibility = View.GONE

        setListeners()
    }

    private fun setListeners() {
        /* Нажатие на значок корзины */
        toolbar.shoppingCartBtn.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
        /* Переход к экрану с детальной информацией о продукте */
        testBtn.setOnClickListener{
            val intent = Intent(this, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID, 1)
            }
            startActivity(intent)
        }
    }

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
    }
}
