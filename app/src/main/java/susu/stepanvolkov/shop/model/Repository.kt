package susu.stepanvolkov.shop.model

class Repository {
    /* TODO: работа с базой данных */
    companion object{
        private val emptyProduct =
            Product(-1, "Error", 0.0, 0)
        private val iphone =
            Product(0, "iPhone", 73000.0, 7)
        private val samsung =
            Product(1, "Samsung", 54000.0, 13)
        private val huawei =
            Product(2, "Huawei", 34000.0, 17)

        private val products = mutableListOf(
            iphone,
            samsung,
            huawei
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