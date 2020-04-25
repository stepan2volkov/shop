package susu.stepanvolkov.shop.model

class Repository {
    /* TODO: работа с базой данных */
    companion object{
        private val emptyProduct =
            Product(0, "iPhone", 73000.0, 7)

        private val products = mutableListOf(
            Product(0, "iPhone", 73000.0, 7),
            Product(1, "Samsung", 54000.0, 13),
            Product(2, "Huawei", 34000.0, 17),
            Product(3, "LG", 24000.0),
            Product(4, "Nokia", 14000.0, 2),
            Product(5, "Lenovo", 43999.99, 3),
            Product(6, "Xiaomi", 20000.0, 4),
            Product(7, "NapoleonPhone", 87000.0, 8),
            Product(8, "China Edition Phone", 20000.0, 4),
            Product(9, "Ultra Smart Phone", 107000.0, 0)
        )

        fun getProductById(id: Int): Product {
            products.forEach{ p ->
                if (p.getId()==id) return p
            }
            return emptyProduct
        }

        fun getProducts(): MutableList<Product> {
            return products
        }

        fun getDescriptionById(id: Int): String {
            return "Nothing to show."
        }
    }

}