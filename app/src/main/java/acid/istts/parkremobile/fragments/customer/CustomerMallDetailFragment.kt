package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.activities.staff.AnnouncementAdapter
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.models.Mall
import acid.istts.parkremobile.services.ServiceLocator
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

private const val ARG_PARAM1 = "customer"
private const val ARG_PARAM2 = "mall"

class CustomerMallDetailFragment : Fragment() {
    private var customer: Customer? = null
    private var mall: Mall? = null
    private var announcements = ArrayList<Announcement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            customer = it.getParcelable(ARG_PARAM1)
            mall = it.getParcelable(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_customer_mall_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mallName = view.findViewById<TextView>(R.id.tvMallNameDetail)
        val rvAnnouncements = view.findViewById<RecyclerView>(R.id.rvAnnouncementsMallDetail)
        val rvSegmentation = view.findViewById<RecyclerView>(R.id.rvSegmentationsMallDetail)

        mallName.text = mall?.name

        val announcementAdapter = AnnouncementAdapter(announcements)
        rvAnnouncements.layoutManager = LinearLayoutManager(context)
        rvAnnouncements.adapter = announcementAdapter

        val serviceLocator = ServiceLocator.getInstance()
        serviceLocator.getMallRepository().getMallAnnouncements(slug = mall!!.slug, context = view.context, onSuccess = {
            announcements.clear()
            val obj = JSONObject(it)
            val arr = obj.getJSONArray("data")
            for (i in 0 until arr.length()) {
                val announcement = Announcement(
                    id = arr.getJSONObject(i).getInt("id"),
                    header = arr.getJSONObject(i).getString("header"),
                    content = arr.getJSONObject(i).getString("content"),
                    status = arr.getJSONObject(i).getInt("status"),
                    mall_id = arr.getJSONObject(i).getInt("mall_id"),
                    staff_id = arr.getJSONObject(i).getInt("staff_id"),
                    mall_name = arr.getJSONObject(i).getString("mall_name"),
                )
                announcements.add(announcement)
            }
            announcementAdapter.notifyDataSetChanged()
        }, onError = {

        })
    }

    companion object {
        @JvmStatic
        fun newInstance(customer: Customer, mall: Mall) =
            CustomerMallDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                    putParcelable(ARG_PARAM2, mall)
                }
            }
    }
}