package susu.stepanvolkov.shop.model

import kotlin.math.roundToInt


class Product (
    val id: Int,
    val name: String,
    val price: Double,
    val discountPercent: Int = 0,
    val description: String = "",
    val imageUrl: String = ""
) {

    constructor(p: RemoteProduct) : this(p.id, p.name, p.price, p.discountPercent, p.description, p.imageUrl )

    /**
     * @return price with applied discount determined by [discountPercent]
     */
    fun calcPriceWithDiscount(): Double = price * (1 - discountPercent / 100.0)

    fun calcDiscount(): Double = price * (discountPercent / 100.0)


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