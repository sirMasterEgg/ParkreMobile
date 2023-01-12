package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Customer
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "customer"
private const val ARG_PARAM2 = "addVehicle"

class CustomerVehiclesFragment(
    private val onAddClickListener: Unit
) : Fragment() {
    private var customer: Customer? = null
    private var addVehicle: Unit? = null

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
        return inflater.inflate(R.layout.fragment_customer_vehicles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rvVehicles: RecyclerView = view.findViewById(R.id.rvVehicles)
        val btnAdd: Button = view.findViewById(R.id.btnAddVehiclesCustomer)

        btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameCustomer, CustomerAddVehicleFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(customer: Customer, addClickListener: Unit) =
            CustomerVehiclesFragment(addClickListener).apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                }
            }
    }
}