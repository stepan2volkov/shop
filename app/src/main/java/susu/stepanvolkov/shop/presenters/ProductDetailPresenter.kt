package susu.stepanvolkov.shop.presenters

import android.text.Html
import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import moxy.MvpPresenter
import susu.stepanvolkov.shop.Product
import susu.stepanvolkov.shop.Repository
import susu.stepanvolkov.shop.views.ProductDetailView
import java.lang.StringBuilder

class ProductDetailPresenter: MvpPresenter<ProductDetailView>() {

    fun setProductDetails(id: Int) {
        val product = Repository.getProductById(id)

        val price = Product.format(product.getPrice())
        val priceWithDiscount = Product.format(product.calcPriceWithDiscount())

        viewState.showProductName(product.getName())
        viewState.showProductDescription(Repository.getDescriptionById(id))
        viewState.showProductPrice(price, priceWithDiscount)
    }
}