package susu.stepanvolkov.shop.activity.adapter

import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class CatalogAdapter(
    private val onItemClick: (productId: Int) -> Unit
): RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    private var products: List<Product> = listOf()

    fun setData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

    override fun getItemCount(): Int = products.size


    override fun onBindViewHolder(holder: CatalogAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(p: Product) {
            itemView.productName.text = p.name
            val price = Product.format(p.price)
            val priceWithDiscount = Product.format(p.calcPriceWithDiscount())

            itemView.productPrice.text = if (price==priceWithDiscount) {
                price
            } else {
                val sp = SpannableStringBuilder("$price $priceWithDiscount")
                sp.setSpan(StrikethroughSpan(), 0, price.length, SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE)
                sp
            }
            itemView.setOnClickListener { onItemClick(p.id) }
            itemView.cartItemDropBtn.visibility = View.GONE
            if (p.imageUrl!="") Picasso.get().load(p.imageUrl).into(itemView.productImage)
        }
    }
}