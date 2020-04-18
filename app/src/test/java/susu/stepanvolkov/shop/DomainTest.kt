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
}