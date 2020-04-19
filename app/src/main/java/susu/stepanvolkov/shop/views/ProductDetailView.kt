package susu.stepanvolkov.shop.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProductDetailView: MvpView {
    fun showProductName(name: String)
    fun showProductPrice(price: String, priceWithDiscount: String)
    fun showProductDescription(description: String)
}