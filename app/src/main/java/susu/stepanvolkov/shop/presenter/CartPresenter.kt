package susu.stepanvolkov.shop.presenter

import moxy.MvpPresenter
import susu.stepanvolkov.shop.presenter.view.CartView
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.model.Repository


class CartPresenter: MvpPresenter<CartView>() {

    private val products: MutableList<Product> =
        Repository.getProducts()


    fun setData() {
        viewState.setProducts(products)
        showCartTotals()
    }

    fun removeItem(p: Product) {
        val position = products.indexOf(p)
        products.remove(p)
        viewState.removeItem(position)
        showCartTotals()
    }

    fun insertItem(p: Product) {
        val position = products.size
        products.add(p)
        viewState.insertItem(position)
        showCartTotals()
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
        val totalPrice = products.sumByDouble { product -> product.getPrice() }
        viewState.showTotalPrice(Product.format(totalPrice))
    }

    private fun calcDiscount() {
        val totalDiscount = products.sumByDouble { product -> product.calcDiscount() }
        viewState.showDiscount(Product.format(-totalDiscount))
    }
}