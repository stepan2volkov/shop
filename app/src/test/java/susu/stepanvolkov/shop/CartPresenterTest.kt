package susu.stepanvolkov.shop

import org.junit.Test

import org.junit.Assert.*
import susu.stepanvolkov.shop.domain.Product

class CartPresenterTest {

    @Test
    fun calcTotalPriceInCart() {
        val smartphone = Product("smartphone",45000.0, 5)
        val notebook = Product("notebook",104000.0, 7)
        val microwave = Product("Microwave",4000.0)
        val list = listOf(smartphone, notebook, microwave)

        val cart = CartPresenter(products = list)
        val totalPrice = 45000.0*0.95+104000.0*0.93+4000.0
        val totalFormattedPrice = "%.0fР".format(totalPrice)
        assertEquals("Total Price in Cart",
            totalFormattedPrice, cart.getTotalDiscountPrice())
    }

    @Test
    fun printProductsPriceInCart() {
        val smartphone = Product("smartphone",45001.0, 5)
        val notebook = Product("notebook",104011.0, 7)
        val microwave = Product("microwave",4000.0)
        val list = listOf(smartphone, notebook, microwave)

        val cart = CartPresenter(products = list)
        cart.printProducts()
        println(cart.getTotalDiscountPrice())
    }
}