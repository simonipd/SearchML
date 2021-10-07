package cl.admedios.searchml.ui.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cl.admedios.searchml.R
import cl.admedios.searchml.databinding.ItemRowListBinding
import cl.admedios.searchml.model.ResultData
import cl.admedios.searchml.ui.detail.DetailActivity
import cl.admedios.searchml.util.Constants
import cl.admedios.searchml.util.ProductListCallBack


class ListProductAdapter(productListCallBack: ProductListCallBack, context: Context) :
    RecyclerView.Adapter<ListProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<ResultData>() {

        override fun areItemsTheSame(oldItem: ResultData, newItem: ResultData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResultData, newItem: ResultData): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.itemView.apply {
            val binding = ItemRowListBinding.bind(this)
            binding.tvTitleProduct.text = product.title
            binding.llItem.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(Constants.PRODUCT_NAME,product)
                context.startActivity(intent)
            }
        }
    }
}