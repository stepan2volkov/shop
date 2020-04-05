package susu.stepanvolkov.shop.domain

interface PriceFormatter {
    fun format(price: Double): String
}