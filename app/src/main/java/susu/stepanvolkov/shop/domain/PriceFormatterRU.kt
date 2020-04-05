package susu.stepanvolkov.shop.domain

import kotlin.math.roundToInt

class PriceFormatterRU: Cart.PriceFormatter {
    override fun format(price: Double): String {
        var formatString = "%.2fР"
        val roundedPrice = (100*price).roundToInt()/100.0

        if (roundedPrice - price.roundToInt()==0.0) {
            formatString = "%.0fР"
        }
        return formatString.format(roundedPrice)
    }
}