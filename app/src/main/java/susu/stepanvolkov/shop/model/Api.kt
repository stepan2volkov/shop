package susu.stepanvolkov.shop.model

import retrofit2.http.GET

data class RemoteProduct(
    val id: Int,
    val name: String,
    val price: Double,
    val discountPercent: Int,
    val description: String,
    val imageUrl: String
)

interface Api {
    @GET("api/products")
    suspend fun products(): List<RemoteProduct>
}