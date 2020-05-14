package susu.stepanvolkov.shop.presenter

import android.content.SharedPreferences
import moxy.InjectViewState
import moxy.MvpPresenter
import susu.stepanvolkov.shop.model.CartProductDAO
import susu.stepanvolkov.shop.model.CartProductDAOImpl
import susu.stepanvolkov.shop.presenter.view.CartView
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.model.Repository

@InjectViewState
class CartPresenter(
    private val cart: CartProductDAO
): BasePresenter<CartView>() {

    private val products: MutableList<Product> = Repository.getProductListByIds(cart.list())

    fun setData() {
        viewState.setProducts(products)
        showCartTotals()
    }

    fun removeItem(p: Product) {
        val position = products.indexOf(p)
        products.remove(p)
        viewState.removeItem(position)
        showCartTotals()
        cart.remove(p.id)
    }

    fun insertItem(p: Product) {
        val position = products.size
        products.add(p)
        viewState.insertItem(position)
        showCartTotals()
        cart.add(p.id)
    }

    private fun showCartTotals() {
        calcTotalPrice()
        calcPriceWithDiscount()
        calcDiscount()
    }

    private fun calcPriceWithDiscount() {
        val priceWithDiscount = products.sumByDouble { product -> product.calcPriceWithDiscount() }
        viewState.showPriceWithDiscount(Product.format(priceWithDiscount))
    }


    private fun calcTotalPrice() {
        val totalPrice = products.sumByDouble { product -> product.price }
        viewState.showTotalPrice(Product.format(totalPrice))
    }

    private fun calcDiscount() {
        val totalDiscount = products.sumByDouble { product -> product.calcDiscount() }
        viewState.showDiscount(Product.format(-totalDiscount))
    }
}