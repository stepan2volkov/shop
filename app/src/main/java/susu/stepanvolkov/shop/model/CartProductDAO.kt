package susu.stepanvolkov.shop.model

interface CartProductDAO {
    fun add(productId: Int)
    fun remove(productId: Int)
    fun list(): List<Int>
}