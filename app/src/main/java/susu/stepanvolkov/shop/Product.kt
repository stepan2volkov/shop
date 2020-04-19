package susu.stepanvolkov.shop

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
}