package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Customer
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


private const val ARG_PARAM1 = "customer"

class CustomerHomeFragment : Fragment() {
    private var customer: Customer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            customer = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvName: TextView = view.findViewById(R.id.tvNameHomeCustomer)
        val rvAnnouncements: RecyclerView = view.findViewById(R.id.rvAnnouncementsHomeCustomer)
        val rvReservations: RecyclerView = view.findViewById(R.id.rvReservationsHomeCustomer)

        tvName.text = customer?.name
    }

    companion object {
        @JvmStatic
        fun newInstance(customer: Customer) =
            CustomerHomeFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                }
            }
    }
}