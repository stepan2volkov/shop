package susu.stepanvolkov.shop.domain

import susu.stepanvolkov.shop.CartView
import kotlin.math.roundToInt

class ProductFormatterRU: CartView.ProductFormatter {
    override fun format(price: Double): String {
        val roundedPrice = (100*price).roundToInt()/100.0

        val formatString = if (roundedPrice % 1 > 0) "%.2fР" else "%.0fР"

        return formatString.format(roundedPrice)
    }

    override fun print(products: List<Product>) {
        products.forEach { p -> println(format(p.calcDiscountPrice())) }
    }


}