package acid.istts.parkremobile.adapters.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Announcement
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnnouncementAdapter(
    private val announcements: ArrayList<Announcement>,
    private val onItemClickListener: ((Announcement) -> Unit)? = null
): RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return AnnouncementViewHolder(
            itemView.inflate(
                R.layout.customer_announcement_card, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AnnouncementViewHolder, position: Int) {
        holder.bind(announcements[position])
        holder.btnDetail.setOnClickListener {
            onItemClickListener?.invoke(announcements[position])
        }
    }

    override fun getItemCount(): Int {
        return announcements.size
    }

    inner class AnnouncementViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val tvTitle: TextView = view.findViewById(R.id.tvTitleAnnouncementCard)
        private val tvMall: TextView = view.findViewById(R.id.tvMallAnnouncementCard)
        val btnDetail: Button = view.findViewById(R.id.btnDetailAnnouncementCard)

        fun bind(announcement: Announcement) {
            tvTitle.text = announcement.header
            tvMall.text = announcement.mall_name
        }
    }
}