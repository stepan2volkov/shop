package susu.stepanvolkov.shop.domain

class Cart (var products: List<Product>) {
    /**
     * @return total price of [products] in Cart with applied discount
     */
    fun calcTotalPrice(): Double = products.sumByDouble { product ->  product.calcDiscountPrice()}
}