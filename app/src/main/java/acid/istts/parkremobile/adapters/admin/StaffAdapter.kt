package acid.istts.parkremobile.adapters.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.fragments.admin.AdminDetailStaffFragment
import acid.istts.parkremobile.models.Staff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class StaffAdapter(
    private val staffs : ArrayList<Staff>
) : RecyclerView.Adapter<StaffAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return CustomViewHolder(itemView.inflate(
            R.layout.admin_recyclerview_staff, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val staff = staffs[position]
        holder.bind(staff)
    }

    override fun getItemCount(): Int {
        return staffs.size
    }

    class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val tvName : TextView = view.findViewById(R.id.tvRVNamaStaff)
        private val tvPhone : TextView = view.findViewById(R.id.tvRVStaffPhone)
        private val btnDetail : Button = view.findViewById(R.id.btnDetailMasterStaff)

        fun bind(staff : Staff) {
            tvName.text = staff.name
            tvPhone.text = staff.phone

            btnDetail.setOnClickListener {
                val activity = it!!.context as AppCompatActivity
                val fragment = AdminDetailStaffFragment(staff)
                val transaction = activity.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.framelayoutadmin, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }
}