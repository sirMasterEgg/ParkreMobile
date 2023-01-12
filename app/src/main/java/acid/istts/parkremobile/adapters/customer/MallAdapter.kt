package acid.istts.parkremobile.adapters.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Mall
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MallAdapter(
    private val malls: ArrayList<Mall>,
    private val onItemClickListener: ((Mall) -> Unit)? = null
): RecyclerView.Adapter<MallAdapter.MallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MallViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return MallViewHolder(
            itemView.inflate(
                R.layout.customer_mall_card, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MallViewHolder, position: Int) {
        holder.bind(malls[position])

    }

    override fun getItemCount(): Int {
        return malls.size
    }

    inner class MallViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvMall: TextView = itemView.findViewById(R.id.tvNameMallCard)
        private val tvAddress: TextView = itemView.findViewById(R.id.tvAddressMallCard)
        private val tvPark: TextView = itemView.findViewById(R.id.tvParkMallCard)

        fun bind(mall: Mall) {
            tvMall.text = mall.name
            tvAddress.text = mall.address
            tvPark.text = "Available Space: ${mall.available_space}"
        }

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(malls[adapterPosition])
            }
        }
    }
}