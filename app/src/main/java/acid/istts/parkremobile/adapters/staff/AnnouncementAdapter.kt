package acid.istts.parkremobile.adapters.staff

import acid.istts.parkremobile.R
import acid.istts.parkremobile.fragments.staff.StaffAnnouncementDetailFragment
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.models.Transaction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

class AnnouncementAdapter (
    private val announcements : ArrayList<Announcement>
) : RecyclerView.Adapter<AnnouncementAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return CustomViewHolder(itemView.inflate(
            R.layout.staff_announcement_layout, parent ,false
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
        private val tvHeaderAnnouncement : TextView = view.findViewById(R.id.tvHeaderAnnouncement)

        fun bind(ann : Announcement) {
            tvHeaderAnnouncement.text = ann.header
            btnDetailAnnouncement.setOnClickListener{
                Log.e("Announcement Click", "${ann.header}, ${ann.content}")

                val activity = it!!.context as AppCompatActivity
                val fragment = StaffAnnouncementDetailFragment(ann)
                val transaction : FragmentTransaction = activity.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.mainFragment, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }

}
