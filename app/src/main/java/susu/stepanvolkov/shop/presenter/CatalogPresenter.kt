package susu.stepanvolkov.shop.presenter

import android.util.Log
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import susu.stepanvolkov.shop.model.Api
import susu.stepanvolkov.shop.model.Product
import susu.stepanvolkov.shop.model.Repository
import susu.stepanvolkov.shop.presenter.view.CatalogView
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException

@InjectViewState
class CatalogPresenter(
    private val api: Api
): BasePresenter<CatalogView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch {
            try {
                val remoteProducts = api.products().map{ Product(it) }.toMutableList()
                Repository.setProducts(remoteProducts)
                viewState.setCatalogList(remoteProducts)
            } catch (e: ConnectException) {
                viewState.showError("Проверьте интернет соединение")
            } catch (e: UnknownHostException) {
                viewState.showError("Хост не найден. Сервер запущен?")
            } catch (e: SocketException) {
                viewState.showError("Нет ответа от сервера")
            } catch (e: Exception) {
                viewState.showError("Неизвестная ошибка")
                Log.d("CatalogPresenter", e.message)
                Log.d("CatalogPresenter", e.cause.toString())
            }
        }
    }
}