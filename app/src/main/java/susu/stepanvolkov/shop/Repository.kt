package susu.stepanvolkov.shop

class Repository {
    private val iphone = Product(1,"iPhone", 73000.0, 7)
    private val samsung = Product(2, "Samsung", 54000.0, 13)
    private val huawei = Product(3, "Huawei", 34000.0, 17)

    private val products = listOf(iphone, samsung, huawei)

    fun getProductById(id: Int): Product? {
        products.forEach{p ->
            if (p.getId()==id) return p
        }
        return null
    }
}