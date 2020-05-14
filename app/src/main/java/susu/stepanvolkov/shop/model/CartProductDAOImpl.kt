package susu.stepanvolkov.shop.model

import android.content.SharedPreferences
import androidx.core.content.edit

class CartProductDAOImpl(
    private val sharedPreferences: SharedPreferences
): CartProductDAO {

    private var savedProductIds: List<Int>
        get() = sharedPreferences.getString(CART_PRODUCT_TAG, null)
            ?.split(",")
            ?.mapNotNull { it.toIntOrNull() } ?: emptyList()
        set(value) {
            sharedPreferences.edit {
                putString(CART_PRODUCT_TAG, value.joinToString(","))
            }
        }

    override fun add(productId: Int) {
        savedProductIds = mutableListOf<Int>().apply {
            add(productId)
            addAll(savedProductIds.filter { it != productId })
        }
    }

    override fun remove(productId: Int) {
        savedProductIds = mutableListOf<Int>().apply {
            addAll(savedProductIds.filter { it != productId })
        }
    }

    override fun list(): List<Int> {
        return savedProductIds
    }

    companion object {
        private const val CART_PRODUCT_TAG = "CART_PRODUCT_TAG"
    }
}