package susu.stepanvolkov.shop.domain

class Cart (var products: List<Product>) {
    /**
     * @return formatted total price of [products] in Cart with applied discount
     */
    fun getPrice(formatter: PriceFormatter): String {
        val totalPrice = products.sumByDouble { product -> product.calcDiscountPrice() }
        return formatter.format(totalPrice)
    }
}