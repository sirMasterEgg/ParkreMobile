package acid.istts.parkremobile.adapters.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.fragments.admin.AdminDetailCustomerFragment
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.models.Reservation
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter (
    private val customers : ArrayList<Customer>
//    private val reservationList : ArrayList<Reservation>
) : RecyclerView.Adapter<CustomerAdapter.CustomViewHolder>() {
//    private val reservationList : ArrayList<Reservation> = arrayListOf()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder{
            val itemView = LayoutInflater.from(parent.context)
            return CustomViewHolder(itemView.inflate(
                R.layout.admin_recyclerview_customer, parent ,false
            ))
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val cust = customers[position]
            holder.bind(cust)

        }

        override fun getItemCount(): Int {
            return customers.size
        }

        class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            private val tvName : TextView = view.findViewById(R.id.tvRVCustomerNama)
            private val tvEmail : TextView = view.findViewById(R.id.tvRVStaffEmail)
            private val tvPhone : TextView = view.findViewById(R.id.tvRVCustomerPhone)
            private val btnDetail : TextView = view.findViewById(R.id.btnDetailMasterCustomer)

            fun bind(cust : Customer) {
                tvName.text = cust.name
                tvEmail.text = cust.email
                tvPhone.text = cust.phone
                val reservationList : ArrayList<Reservation> = arrayListOf()

                reservationList.add(Reservation(1, "13:00", "19:00", 25000, 1, "2023-01-31", 1, 1, 1, "Customer 1", "L 010 K", "Segmentation 1", "Mall 1"))
                reservationList.add(Reservation(2, "13:00", "19:00", 25000, 1, "2023-01-31", 1, 1, 1, "Customer 1", "L 010 K", "Segmentation 1", "Mall 1"))
                reservationList.add(Reservation(3, "13:00", "19:00", 25000, 1, "2023-01-31", 1, 1, 1, "Customer 1", "L 010 K", "Segmentation 1", "Mall 1"))
                reservationList.add(Reservation(4, "13:00", "19:00", 25000, 1, "2023-01-31", 1, 1, 1, "Customer 1", "L 010 K", "Segmentation 1", "Mall 1"))

                val detailCustomerAdapter = DetailCustomerAdapter(reservationList)
                btnDetail.setOnClickListener{
                    Log.e("Customer Click", "${cust.name}, ${cust.email}, ${cust.phone}")
                    val activity = it!!.context as AppCompatActivity
                    val fragment = AdminDetailCustomerFragment(detailCustomerAdapter, cust)
                    val transaction : FragmentTransaction = activity.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.framelayoutadmin, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }

}