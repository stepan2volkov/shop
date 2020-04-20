package susu.stepanvolkov.shop.model

import kotlin.math.roundToInt

class Product (
    private val id: Int,
    private val name: String,
    private val price: Double,
    private val salePercent: Int = 0) {
    /**
     * @return price with applied discount determined by [salePercent]
     */
    fun calcPriceWithDiscount(): Double = price * (1 - salePercent / 100.0)

    fun calcDiscount(): Double = price * (salePercent / 100.0)

    fun getId(): Int = id

    fun getName(): String = name

    fun getPrice(): Double = price

    fun getSalePercent(): Int = salePercent

    companion object{
        /**
         * @return formatted price. For example, "1001.50 Р" or "7500 Р".
         * */
        fun format(price: Double): String {
            val roundedPrice = (100*price).roundToInt()/100.0

            val formatString = if (roundedPrice % 1 > 0) "%.2f Р" else "%.0f Р"
            return formatString.format(roundedPrice)
        }
    }
}