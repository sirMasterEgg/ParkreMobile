package acid.istts.parkremobile.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.admin.DetailCustomerAdapter
import acid.istts.parkremobile.models.Customer
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdminDetailCustomerFragment(
    var detailCustomerAdapter: DetailCustomerAdapter,
    var customer: Customer
) : Fragment() {
    lateinit var rvDetailCustomer: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_detail_customer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvName : TextView = view.findViewById(R.id.tvDetailCustomerName)
        val tvEmail : TextView = view.findViewById(R.id.tvDetailCustomerEmail)
        val tvPhone : TextView = view.findViewById(R.id.tvDetailCustomerPhone)
        val tvAddress : TextView = view.findViewById(R.id.tvDetailCustomerAddress)
        rvDetailCustomer = view.findViewById(R.id.rvDetailCustomer)

        tvName.text = "Name : ${customer.name}"
        tvEmail.text = "Email : ${customer.email}"
        tvPhone.text = "Phone : ${customer.phone}"
        tvAddress.text = "Address : ${customer.address}"
        rvDetailCustomer.adapter = detailCustomerAdapter
        rvDetailCustomer.layoutManager = LinearLayoutManager(context)
    }
}