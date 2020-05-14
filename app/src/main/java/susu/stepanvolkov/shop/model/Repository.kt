package susu.stepanvolkov.shop.model

class Repository {

    companion object{
        private val emptyProduct =
            Product(0, "iPhone", 73000.0, 7)

        private var products = mutableListOf<Product>()

        fun setProducts(products: MutableList<Product>) {
            this.products = products
        }

        fun getProductById(id: Int): Product {
            products.forEach{ p -> if (p.id==id) return p }
            return emptyProduct
        }

        fun getProducts(): MutableList<Product> {
            return products
        }

        fun getDescriptionById(id: Int): String {
            return getProductById(id).description
        }

        fun getProductListByIds(ids: List<Int>): MutableList<Product> {
            return ids.map { id-> getProductById((id)) }.toMutableList()
        }
    }

}