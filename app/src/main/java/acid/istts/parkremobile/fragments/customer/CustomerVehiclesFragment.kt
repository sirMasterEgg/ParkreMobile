package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.customer.VehicleAdapter
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.models.Vehicle
import acid.istts.parkremobile.services.ServiceLocator
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

private const val ARG_PARAM1 = "customer"

class CustomerVehiclesFragment() : Fragment() {
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
        return inflater.inflate(R.layout.fragment_customer_vehicles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val serviceLocator = ServiceLocator.getInstance()
        val vehicles: ArrayList<Vehicle> = ArrayList()

        val vehicleAdapter = VehicleAdapter(vehicles = vehicles,
        onEditClickListener = {

        },
        onDeleteClickListener = {

        })

        serviceLocator.getVehicleRepository().fetchVehicles(customer!!.token,
        onSuccess = {
            val o = JSONObject(it)
            println(it)
            val obj = o.getJSONArray("data")
            for (i in 0 until obj.length()) {
                val vehicle = Vehicle(
                    id = obj.getJSONObject(i).getInt("id"),
                    name = obj.getJSONObject(i).getString("name"),
                    plate = obj.getJSONObject(i).getString("plate"),
                    color = obj.getJSONObject(i).getString("color"),
                    user_id = obj.getJSONObject(i).getInt("user_id"),
                )
                vehicles.add(vehicle)
                vehicleAdapter.notifyItemInserted(vehicles.size - 1)
            }
        },
        onError = {

        },
        context = view.context)

        val rvVehicles: RecyclerView = view.findViewById(R.id.rvVehicles)
        rvVehicles.adapter = vehicleAdapter
        rvVehicles.layoutManager = LinearLayoutManager(view.context)

        val btnAdd: Button = view.findViewById(R.id.btnAddVehiclesCustomer)

        btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameCustomer, CustomerAddVehicleFragment.newInstance(customer!!))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(customer: Customer) =
            CustomerVehiclesFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                }
            }
    }
}