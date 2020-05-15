package susu.stepanvolkov.shop.presenter

import androidx.core.text.isDigitsOnly
import moxy.InjectViewState
import moxy.MvpPresenter
import susu.stepanvolkov.shop.model.CartProductDAO
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.model.Repository
import susu.stepanvolkov.shop.presenter.view.CheckoutView
import javax.inject.Inject

@InjectViewState
class CheckoutPresenter @Inject constructor(
    private val cart: CartProductDAO
): BasePresenter<CheckoutView>() {

    private val products: MutableList<Product> = Repository.getProductListByIds(cart.list())

    /**
     * @return formatted total price of [products] in Cart with applied discount
     */
    fun getProducts(): List<Product> = products

    fun showCartTotals() {
        calcTotalPrice()
        calcPriceWithDiscount()
        calcDiscount()
    }

    private fun calcPriceWithDiscount() {
        val priceWithDiscount = products.sumByDouble { product -> product.calcPriceWithDiscount() }
        viewState.showPriceWithDiscount(Product.format(priceWithDiscount))
    }


    private fun calcTotalPrice() {
        val totalPrice = products.sumByDouble { product -> product.price }
        viewState.showTotalPrice(Product.format(totalPrice))
    }

    private fun calcDiscount() {
        val totalDiscount = products.sumByDouble { product -> product.calcDiscount() }
        viewState.showDiscount(Product.format(-totalDiscount))
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
            (phone[0]=='+') and (phone[1]=='7') -> phone.substring(2)
            (phone[0]=='8') and (phone.length==11) -> phone.substring(1)
            else -> return false
        }

        return number.isDigitsOnly() and (number.length==10)
    }
}