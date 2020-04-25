package susu.stepanvolkov.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.presenter.CheckoutPresenter
import susu.stepanvolkov.shop.presenter.view.CheckoutView

class CheckoutActivity : AppCompatActivity(), CheckoutView {

    private val presenter = CheckoutPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        toolbar.headerText.text = getString(R.string.checkout_header)
        toolbar.headerBackBtn.setOnClickListener{ finish() }
        toolbar.shoppingCartBtn.visibility = View.GONE

        presenter.attachView(this)
        presenter.showCartTotals()

        setListeners()
    }

    private fun setListeners() {
        firstName.addTextChangedListener(getNameWatcher(firstName))
        lastName.addTextChangedListener(getNameWatcher(lastName))
        middleName.addTextChangedListener(getNameWatcher(middleName))

        phone.onFocusChangeListener = View.OnFocusChangeListener{_, hasFocus ->
            if(!hasFocus) {
                val valid = presenter.checkNumber(phone.text.toString())
                phone.showError(!valid)
            }
        }
    }

    override fun showTotalPrice(price: String) {
        fullPrice.text = price
    }

    override fun showDiscount(discountPrice: String) {
        discount.text = discountPrice
    }

    override fun showPriceWithDiscount(price: String) {
        priceWithDiscount.text = price
    }

    fun EditText.showError(invalid: Boolean) {
        val drawable = if (invalid) R.drawable.ic_error else 0;
        this.setCompoundDrawablesWithIntrinsicBounds(0,0,drawable, 0)
    }

    /* return TextChangedListener for name fields */
    private fun getNameWatcher(editText: EditText): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val valid = presenter.checkName(s.toString())
                editText.showError(!valid)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }
}
