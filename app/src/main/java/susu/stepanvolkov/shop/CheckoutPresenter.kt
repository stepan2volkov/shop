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
     * @return true if name is valid.
     */
    fun checkName(name: String): Boolean = (name.length > 1)

    /**
     * @return true is phone number is valid
     */
    fun checkNumber(phone: String): Boolean {
        if (phone.length<11) return false

        val number: String = when {
            (phone[0]=='+') and (phone[1]=='7') -> {
                phone.substring(2)
            }
            (phone[0]=='8') and (phone.length==11) -> {
                phone.substring(1)
            }
            else -> {
                return false
            }
        }

        return number.isDigitsOnly() and (number.length==10)
    }
}