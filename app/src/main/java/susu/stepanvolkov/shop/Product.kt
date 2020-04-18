package susu.stepanvolkov.shop

class Product (
    private val name: String,
    private val price: Double,
    private val salePercent: Int = 0) {
    /**
     * @return price with applied discount determined by [salePercent]
     */
    fun calcPriceWithDiscount(): Double = price * (1 - salePercent / 100.0)

    fun calcDiscount(): Double = price * (salePercent / 100.0)

    fun getName(): String = name

    fun getPrice(): Double = price

    companion object {
        /**
         * @return list of products. Test implementation yet.
         */
        fun getProducts(): List<Product> {
            val iphone = Product("iPhone", 73000.0, 7)
            val samsung = Product("Samsung", 54000.0, 13)

            return listOf(iphone, samsung)
        }
    }
}