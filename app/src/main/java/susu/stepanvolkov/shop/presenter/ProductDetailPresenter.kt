package susu.stepanvolkov.shop.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import susu.stepanvolkov.shop.model.CartProductDAO
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.model.Repository
import susu.stepanvolkov.shop.presenter.view.ProductDetailView
import javax.inject.Inject

@InjectViewState
class ProductDetailPresenter @Inject constructor(
    private val cart: CartProductDAO
): BasePresenter<ProductDetailView>() {

    fun setProductDetails(id: Int) {
        val product = Repository.getProductById(id)

        val price = Product.format(product.price)
        val priceWithDiscount = Product.format(product.calcPriceWithDiscount())

        viewState.showProductName(product.name)
        viewState.showProductDescription(product.description)
        viewState.showProductPrice(price, priceWithDiscount)
        viewState.setImage(product.imageUrl)
    }
    fun onAddToCart(productId: Int) {
        viewState.changeBtn()
        cart.add(productId)
    }
}