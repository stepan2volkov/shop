package susu.stepanvolkov.shop.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CheckoutView: MvpView {

    /* Cart information methods */
    fun showTotalPrice(price: String)
    fun showDiscount(discountPrice: String)
    fun showPriceWithDiscount(price: String)
}