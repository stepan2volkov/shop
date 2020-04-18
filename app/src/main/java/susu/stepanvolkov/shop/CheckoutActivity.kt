package susu.stepanvolkov.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        val presenter = CartPresenter()

        fullPrice.text = presenter.getTotalPrice()
        discount.text = presenter.getDiscount()
        priceWithDiscount.text = presenter.getTotalDiscountPrice()
    }
}
