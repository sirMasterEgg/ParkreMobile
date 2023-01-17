package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.services.ServiceLocator
import android.content.Context
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.runBlocking

private const val ARG_PARAM1 = "customer"

class CustomerAddVehicleFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_customer_add_vehicle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val etVehicleName: EditText = view.findViewById(R.id.etNameAddVehicle)
        val etVehiclePlate: EditText = view.findViewById(R.id.etPlateAddVehicle)
        val btnAddVehicle: View = view.findViewById(R.id.btnAddVehicle)

        btnAddVehicle.setOnClickListener {
            if (etVehicleName.text.isEmpty() && etVehiclePlate.text.isEmpty()){
                Toast.makeText(view.context, "All field is required!", Toast.LENGTH_SHORT).show()
            }
            else{
                runBlocking {
                    createVehicle(etVehicleName.text.toString(), etVehiclePlate.text.toString(), view.context)
                }
                Toast.makeText(view.context, "Vehicle added!", Toast.LENGTH_SHORT).show()
                parentFragmentManager.popBackStack()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(customer: Customer) =
            CustomerAddVehicleFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                }
            }
    }

    private suspend fun createVehicle(vehicle_name: String, vehicle_plate: String, context: Context){
        val serviceLocator = ServiceLocator.getInstance()
        serviceLocator.getVehicleRepository().createVehicle(
            vehicle_name,
            vehicle_plate,
            customer!!.id,
            customer!!.token,
            onSuccess = {
                println(it)
            },
            onError = {
                println(String(it.networkResponse.data, Charsets.UTF_8))
            },
            context = context
        )
    }
}