package susu.stepanvolkov.shop

import susu.stepanvolkov.shop.domain.Product

class CartPresenter (
    private val products: List<Product> = emptyList<Product>(),
    private val formatter: ProductFormatter
) {
    interface ProductFormatter {
        fun format(price: Double): String
        fun print(products: List<Product>)
    }

    /**
     * @return formatted total price of [products] in Cart with applied discount
     */
    fun getTotalPrice(): String {
        val totalPrice = products.sumByDouble { product -> product.calcDiscountPrice() }
        return formatter.format(totalPrice)
    }

    fun printProducts() = formatter.print(products)
}