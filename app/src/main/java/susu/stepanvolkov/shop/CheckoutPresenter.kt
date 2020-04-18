package susu.stepanvolkov.shop

import androidx.core.text.isDigitsOnly
import moxy.MvpPresenter


class CheckoutPresenter(): MvpPresenter<CheckoutView>() {

    private val products: List<Product> = Product.getProducts()

    /**
     * @return formatted total price of [products] in Cart with applied discount
     */
    fun calcTotalDiscountPrice() {
        val totalPrice = products.sumByDouble { product -> product.calcPriceWithDiscount() }
        viewState.showPriceWithDiscount(totalPrice)
    }


    fun calcTotalPrice() {
        val totalPrice = products.sumByDouble { product -> product.getPrice() }
        viewState.showTotalPrice(totalPrice)
    }

    fun calcDiscount() {
        val totalDiscount = products.sumByDouble { product -> product.calcDiscount() }
        viewState.showDiscount(totalDiscount)
    }

    /**
     * @return [true] if name is invalid.
     */
    fun validateNameError(name: String): Boolean = (name.length < 2)

    fun validatePhoneNumber(phone: String): Boolean {
        val number = if (phone[0]=='+') phone.substring(1) else phone

        return !number.isDigitsOnly() or (number.length!=11)
    }
}