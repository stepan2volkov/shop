package susu.stepanvolkov.shop

import org.junit.Test

import org.junit.Assert.*

class DomainTest {

    @Test
    fun calcProductPriceWithDiscount() {
        val smartphone =
            Product("Smartphone", 10000.0, 25)
        val priceWithDiscount = 10000.0*0.75
        assertEquals("Price with discount",
            priceWithDiscount, smartphone.calcPriceWithDiscount(), 0.0)
    }

    @Test
    fun priceFormatterRU() {
        val view: CheckoutPresenter.CartView = CartViewRU()
        assertEquals("123,01Р", view.format(123.01))
        assertEquals("100Р", view.format(100.001))
        assertEquals("100,99Р", view.format(100.99))
        assertEquals("101Р", view.format(100.995))
    }
}