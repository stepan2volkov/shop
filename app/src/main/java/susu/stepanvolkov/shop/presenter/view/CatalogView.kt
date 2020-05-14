package susu.stepanvolkov.shop.presenter.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import susu.stepanvolkov.shop.model.Product

@StateStrategyType(AddToEndSingleStrategy::class)
interface CatalogView: MvpView {
    fun setCatalogList(products: MutableList<Product>)
    fun showError(msg: String)
}