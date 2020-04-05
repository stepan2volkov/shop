package susu.stepanvolkov.shop.domain

import kotlin.math.roundToInt

class PriceFormatterRU: PriceFormatter {
    override fun format(price: Double): String {
        var formatString = "%.2f"
        val roundedPrice = (100*price).roundToInt()/100.0

        if (roundedPrice - price.roundToInt()==0.0) {
            formatString = "%.0f"
        }
        return formatString.format(roundedPrice)
    }
}