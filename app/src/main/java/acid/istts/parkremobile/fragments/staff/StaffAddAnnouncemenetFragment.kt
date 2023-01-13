package acid.istts.parkremobile.fragments.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.services.ServiceLocator
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class StaffAddAnnouncemenetFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_add_announcemenet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBack : Button = view.findViewById(R.id.btnBackAdd)
        val btnAdd : Button = view.findViewById(R.id.btnAddAnnouncement)
        val spMall : Spinner = view.findViewById(R.id.spListMall)
        val etHeader : EditText = view.findViewById(R.id.etAnnHeader)
        val etContent : EditText = view.findViewById(R.id.etAnnContent)

        btnAdd.setOnClickListener {
            val header = etHeader.text.toString()
            val content = etContent.text.toString()
//            val mall = spMall.selectedItem.toString()
            var valid : Boolean = false

            if (header.isEmpty()){
                etHeader.error = "Header cannot be empty"
            } else if (content.isEmpty()){
                etContent.error = "Content cannot be empty"
            } else {
                valid = true
            }

            if(valid){
                //TODO : Add Announcement
            }
        }

        btnBack.setOnClickListener {
            val supportFragmentManager = activity?.supportFragmentManager
            supportFragmentManager?.popBackStackImmediate()
        }
    }
}