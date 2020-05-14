package susu.stepanvolkov.shop.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import susu.stepanvolkov.shop.presenter.view.CatalogView

@InjectViewState
class CatalogPresenter: MvpPresenter<CatalogView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        // TODO: получить список продуктов через Retrofit
        // products =
        // viewState.setCatalogList(products)
    }
}