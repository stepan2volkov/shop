package susu.stepanvolkov.shop.domain

class Cart (var products: List<Product> = emptyList<Product>()) {

    interface PriceFormatter {
        fun format(price: Double): String
        fun print(products: List<Product>)
    }

    /**
     * @return formatted total price of [products] in Cart with applied discount
     */
    fun getTotalPrice(formatter: PriceFormatter): String {
        val totalPrice = products.sumByDouble { product -> product.calcDiscountPrice() }
        return formatter.format(totalPrice)
    }

    fun printProducts(formatter: PriceFormatter) = formatter.print(products)
}