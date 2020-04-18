package susu.stepanvolkov.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlin.math.roundToInt

class CheckoutActivity : AppCompatActivity(), CheckoutView {
    private val presenter = CheckoutPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        presenter.attachView(this)
        presenter.calcTotalPrice()
        presenter.calcDiscount()
        presenter.calcTotalDiscountPrice()

        setListeners()
    }

    private fun setListeners() {
        firstName.addTextChangedListener(getNameWatcher(firstName))
        lastName.addTextChangedListener(getNameWatcher(firstName))
        middleName.addTextChangedListener(getNameWatcher(firstName))

        phone.onFocusChangeListener = View.OnFocusChangeListener{v, hasFocus ->
            if(!hasFocus) {
                val hasError = presenter.validatePhoneNumber(phone.text.toString())
                phone.showError(hasError)
            }
        }
    }

    override fun showTotalPrice(price: Double) {
        fullPrice.text = format(price)
    }

    override fun showDiscount(discountPrice: Double) {
        discount.text = format(discountPrice)
    }

    override fun showPriceWithDiscount(price: Double) {
        priceWithDiscount.text = format(price)
    }

    fun EditText.showError(hasError: Boolean) {
        val drawable = if (hasError) R.drawable.ic_error else 0;
        this.setCompoundDrawablesWithIntrinsicBounds(0,0,drawable, 0)
    }

    /* return TextChangedListener for name fields */
    private fun getNameWatcher(editText: EditText): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val hasError = presenter.validateNameError(s.toString())
                editText.showError(hasError)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }
    /**
     * @return formatted price. For example, "1001.50 Р" or "7500 Р".
     * */
    fun format(price: Double): String {
        val roundedPrice = (100*price).roundToInt()/100.0

        val formatString = if (roundedPrice % 1 > 0) "%.2f Р" else "%.0f Р"
        return formatString.format(roundedPrice)
    }
}
