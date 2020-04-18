package susu.stepanvolkov.shop

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import kotlin.math.roundToInt

@StateStrategyType(AddToEndSingleStrategy::class)
interface CheckoutView: MvpView {
    /**
     * @return formatted price. For example, "1001.50 Р" or "7500 Р".
     * */
    fun format(price: Double): String {
        val roundedPrice = (100*price).roundToInt()/100.0

        val formatString = if (roundedPrice % 1 > 0) "%.2f Р" else "%.0f Р"
        return formatString.format(roundedPrice)
    }

    /* Cart information methods */
    fun showTotalPrice(price: Double)
    fun showDiscount(discountPrice: Double)
    fun showPriceWithDiscount(price: Double)
}