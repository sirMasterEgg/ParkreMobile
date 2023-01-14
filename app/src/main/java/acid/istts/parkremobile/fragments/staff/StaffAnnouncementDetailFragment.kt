package acid.istts.parkremobile.fragments.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Announcement
import android.widget.Button
import android.widget.TextView

class StaffAnnouncementDetailFragment(
    var announcement : Announcement
) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_announcement_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvHeader : TextView = view.findViewById(R.id.tvHeaderDetail)
        val tvContent : TextView = view.findViewById(R.id.tvContentDetail)
        val btnBack : Button = view.findViewById(R.id.btnBackDetail)

        tvHeader.text = "${announcement.header}"
        tvContent.text = "${announcement.content}"
        btnBack.setOnClickListener {
            val supportFragmentManager = activity?.supportFragmentManager
            supportFragmentManager?.popBackStackImmediate()
        }
    }
}