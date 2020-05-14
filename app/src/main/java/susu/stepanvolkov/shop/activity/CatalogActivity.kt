package susu.stepanvolkov.shop.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_catalog.*
import kotlinx.android.synthetic.main.activity_checkout.toolbar
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.activity.adapter.CatalogAdapter
import susu.stepanvolkov.shop.model.Api
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.presenter.CatalogPresenter
import susu.stepanvolkov.shop.presenter.view.CatalogView

class CatalogActivity : MvpAppCompatActivity(), CatalogView {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.105:5000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(Api::class.java)
    private val presenter by moxyPresenter { CatalogPresenter(service) }
    private val adapter = CatalogAdapter { id ->
        val intent = Intent(this, ProductDetailActivity::class.java).apply {
            putExtra(PRODUCT_ID, id)
            flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        /* Toolbar initialization */
        toolbar.headerText.text = getString(R.string.catalog_header)
        toolbar.headerBackBtn.visibility = View.GONE

        presenter.attachView(this)

        setListeners()
        catalogList.layoutManager = LinearLayoutManager(this)
        catalogList.adapter = adapter
    }

    private fun setListeners() {
        /* Нажатие на значок корзины */
        toolbar.shoppingCartBtn.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
    }

    override fun setCatalogList(products: MutableList<Product>) {
        adapter.setData(products)
    }

    override fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}