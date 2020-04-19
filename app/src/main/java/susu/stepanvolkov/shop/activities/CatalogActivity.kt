package susu.stepanvolkov.shop.activities

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
    }

    private fun setListeners() {
        /* Нажатие на знакок корзины */
        toolbar.shoppingCartBtn.setOnClickListener{
            // TODO: Переход к CartActivity
        }
        /* Переход к экрану с детальной информацией о продукте */
        testBtn.setOnClickListener{
            // TODO: Переход к ProductDetailActivity
        }
    }
}
