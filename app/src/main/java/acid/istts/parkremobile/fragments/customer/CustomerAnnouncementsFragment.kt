package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.customer.AnnouncementAdapter
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.services.ServiceLocator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class CustomerAnnouncementsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_announcements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val serviceLocator = ServiceLocator.getInstance()
        val announcements: ArrayList<Announcement> = ArrayList()

        val announcementAdapter = AnnouncementAdapter(announcements,
            onItemClickListener = {
                val fragment = CustomerAnnouncementDetailFragment.newInstance(it)
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.frameCustomer, fragment)
                transaction?.addToBackStack(null)
                transaction?.commit()
            })
        serviceLocator.getAnnouncementRepository().fetchAnnouncement(onSuccess = {
            val o = JSONObject(it)
            val obj = o.getJSONArray("announcements")
            for (i in 0 until obj.length()) {
                val announcement = Announcement(
                    id = obj.getJSONObject(i).getInt("id"),
                    header = obj.getJSONObject(i).getString("header"),
                    content = obj.getJSONObject(i).getString("content"),
                    created_at = obj.getJSONObject(i).getString("created_at"),
                    status = obj.getJSONObject(i).getInt("status"),
                    mall_id = obj.getJSONObject(i).getInt("mall_id"),
                    staff_id = obj.getJSONObject(i).getInt("staff_id"),
                    mall_name = obj.getJSONObject(i).getString("mall_name")
                )
                announcements.add(announcement)
                announcementAdapter.notifyItemInserted(announcements.size - 1)
            }
        },
        onError = {

        },
        context = view.context)

        val rvAnnouncements: RecyclerView = view.findViewById(R.id.rvAnnouncements)

        rvAnnouncements.adapter = announcementAdapter
        rvAnnouncements.layoutManager = LinearLayoutManager(view.context)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CustomerAnnouncementsFragment()
    }
}