package susu.stepanvolkov.shop

import org.junit.Test

import org.junit.Assert.*
import susu.stepanvolkov.shop.domain.Cart
import susu.stepanvolkov.shop.domain.Product

class DomainTest {

    @Test
    fun calcProductPriceWithDiscount() {
        val smartphone = Product(10000.0,25)
        val priceWithDiscount = 10000.0*0.75
        assertEquals("Price with discount",
            priceWithDiscount, smartphone.calcDiscountPrice(), 0.0)
    }

    @Test
    fun calcTotalPriceInCart() {
        val smartphone = Product(45000.0, 5)
        val notebook = Product(104000.0, 7)
        val microwave = Product(4000.0)
        val list = listOf(smartphone, notebook, microwave)

        val cart = Cart(list)
        val totalPrice = 45000.0*0.95+104000.0*0.93+4000.0
        assertEquals("Total Price in Cart",
            totalPrice, cart.calcTotalPrice(), 0.0)
    }
}