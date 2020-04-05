package susu.stepanvolkov.shop.domain

class Product (private val price: Double, private val salePercent: Int = 0) {
    /**
     * @return price with applied discount determined by [salePercent]
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}