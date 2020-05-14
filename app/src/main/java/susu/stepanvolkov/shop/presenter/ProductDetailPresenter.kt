package susu.stepanvolkov.shop.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.model.Repository
import susu.stepanvolkov.shop.presenter.view.ProductDetailView

@InjectViewState
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