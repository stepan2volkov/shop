package susu.stepanvolkov.shop.presenter.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import susu.stepanvolkov.shop.model.Product

@StateStrategyType(AddToEndSingleStrategy::class)
interface CartView: MvpView {

    /* Cart information methods */
    fun showTotalPrice(price: String)
    fun showDiscount(discountPrice: String)
    fun showPriceWithDiscount(price: String)
    fun setProducts(products: MutableList<Product>)
    fun removeItem(position: Int)
    fun insertItem(position: Int)
}