package susu.stepanvolkov.shop.activity.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import susu.stepanvolkov.shop.model.Product

class CatalogAdapter: RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CatalogAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(p: Product) {
//            itemView.productName.text = p.getName()
//            val price = Product.format(p.getPrice())
//            val priceWithDiscount = Product.format(p.calcPriceWithDiscount())
//
//            itemView.productPrice.text = if (price==priceWithDiscount) {
//                price
//            } else {
//                val sp = SpannableStringBuilder("$price $priceWithDiscount")
//                sp.setSpan(StrikethroughSpan(), 0, price.length, SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE)
//                sp
//            }
//
//            itemView.cartItemDropBtn.setOnClickListener{ onDropItemClick(p) }
        }
    }
}