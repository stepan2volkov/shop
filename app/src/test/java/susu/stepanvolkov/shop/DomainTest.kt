package susu.stepanvolkov.shop

import org.junit.Test

import org.junit.Assert.*
import susu.stepanvolkov.shop.domain.ProductFormatterRU
import susu.stepanvolkov.shop.domain.Product

class DomainTest {

    @Test
    fun calcProductPriceWithDiscount() {
        val smartphone = Product("Smartphone", 10000.0,25)
        val priceWithDiscount = 10000.0*0.75
        assertEquals("Price with discount",
            priceWithDiscount, smartphone.calcPriceWithDiscount(), 0.0)
    }

    @Test
    fun priceFormatterRU() {
        val formatter: CartPresenter.ProductFormatter = ProductFormatterRU()
        assertEquals("123,01Р", formatter.format(123.01))
        assertEquals("100Р", formatter.format(100.001))
        assertEquals("100,99Р", formatter.format(100.99))
        assertEquals("101Р", formatter.format(100.995))
    }
}