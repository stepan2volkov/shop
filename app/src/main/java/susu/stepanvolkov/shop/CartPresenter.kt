package susu.stepanvolkov.shop

import susu.stepanvolkov.shop.domain.Product
import susu.stepanvolkov.shop.domain.ProductFormatterRU


class CartPresenter (
    private val formatter: ProductFormatter = ProductFormatterRU(),
    private val products: List<Product> = Product.getProducts()
) {
    interface ProductFormatter {
        fun format(price: Double): String
        fun print(products: List<Product>)
    }



    /**
     * @return formatted total price of [products] in Cart with applied discount
     */
    fun getTotalPrice(): String {
        val totalPrice = products.sumByDouble { product -> product.calcPriceWithDiscount() }
        return formatter.format(totalPrice)
    }

    fun printProducts() = formatter.print(products)
}