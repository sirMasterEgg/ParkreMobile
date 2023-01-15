package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import android.widget.Button
import android.widget.TextView

class AdminAnnouncementDetail : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_announcement_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val TvAdminHeaderDetail : TextView = view.findViewById(R.id.tvAdminHeaderDetail)
        val TvAdminContentDetail : TextView = view.findViewById(R.id.tvAdminContentDetail)
        val BtnAdminBackDetail : Button = view.findViewById(R.id.btnAdminBackDetail)

        BtnAdminBackDetail.setOnClickListener(){
            val supportFragmentManager = activity?.supportFragmentManager
            supportFragmentManager?.popBackStackImmediate()
        }
    }
}