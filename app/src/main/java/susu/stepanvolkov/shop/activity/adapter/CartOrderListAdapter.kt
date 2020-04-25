package susu.stepanvolkov.shop.activity.adapter

import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cart_product.view.*
import susu.stepanvolkov.shop.R
import susu.stepanvolkov.shop.model.Product

class CartOrderListAdapter(
    private val onDropItemClick: (p: Product) -> Unit
): RecyclerView.Adapter<CartOrderListAdapter.ViewHolder>() {

    private var products: List<Product> = listOf()

    fun setData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartOrderListAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cart_product, parent, false))

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(p: Product) {
            itemView.productName.text = p.getName()
            val price = Product.format(p.getPrice())
            val priceWithDiscount = Product.format(p.calcPriceWithDiscount())

            itemView.productPrice.text = if (price==priceWithDiscount) {
                price
            } else {
                val sp = SpannableStringBuilder("$price $priceWithDiscount")
                sp.setSpan(StrikethroughSpan(), 0, price.length, SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE)
                sp.toString()
            }

            itemView.cartItemDropBtn.setOnClickListener{ onDropItemClick(p) }
        }
    }

}