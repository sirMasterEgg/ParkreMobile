package acid.istts.parkremobile.activities.staff

import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Announcement
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnnouncementAdapter (
    private val announcements : ArrayList<Announcement>
) : RecyclerView.Adapter<AnnouncementAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return CustomViewHolder(itemView.inflate(
            R.layout.customer_announcement_card, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val ann = announcements[position]
        holder.bind(ann)
    }

    override fun getItemCount(): Int {
        return announcements.size
    }

    class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val btnDetailAnnouncement : Button = view.findViewById(R.id.btnDetailAnnouncement)
        private val tvHeaderAnnouncement : TextView = view.findViewById(R.id.tvAnnouncementTitle)
        private val tvMallAnnouncement : TextView = view.findViewById(R.id.tvMallAnnouncement)

        fun bind(ann : Announcement) {
            tvHeaderAnnouncement.text = ann.header
            tvMallAnnouncement.text = "On: " + ann.mall_name
            btnDetailAnnouncement.setOnClickListener{
                // TODO : Open Detail Announcement
            }
        }
    }

}
