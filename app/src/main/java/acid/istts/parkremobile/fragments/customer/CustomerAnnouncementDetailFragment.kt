package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Announcement
import android.widget.TextView

private const val ARG_PARAM1 = "announcement"

class CustomerAnnouncementDetailFragment : Fragment() {
    private lateinit var announcement: Announcement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            announcement = it.getParcelable(ARG_PARAM1)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_announcement_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvHeader: TextView = view.findViewById(R.id.tvHeaderAnnouncementDetail)
        val tvMall: TextView = view.findViewById(R.id.tvMallAnnouncementDetail)
        val tvContent: TextView = view.findViewById(R.id.tvContentAnnouncementDetail)

        tvHeader.text = announcement.header
        tvMall.text = announcement.mall_name
        tvContent.text = announcement.content
    }

    companion object {

        @JvmStatic
        fun newInstance(announcement: Announcement) =
            CustomerAnnouncementDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, announcement)
                }
            }
    }
}