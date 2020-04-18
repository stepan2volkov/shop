package susu.stepanvolkov.shop

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CheckoutView: MvpView {

    /* Information about totals  */
    fun showTotalPrice(price: Double)
    fun showDiscount(discountPrice: Double)
    fun showPriceWithDiscount(price: Double)
}