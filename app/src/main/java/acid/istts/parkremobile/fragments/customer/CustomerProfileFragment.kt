package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.activities.shared.LoginActivity
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.services.AppDatabase
import android.content.Intent
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "customer"

class CustomerProfileFragment : Fragment() {
    private var customer: Customer? = null
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val db: AppDatabase = AppDatabase.build(view?.context)

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
        return inflater.inflate(R.layout.fragment_customer_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val db: AppDatabase = AppDatabase.build(view.context)
        val btnEdit: Button = view.findViewById(R.id.btnEditProfileCustomer)
        val btnTransactions: Button = view.findViewById(R.id.btnReservationsProfileCustomer)
        val btnLogout: Button = view.findViewById(R.id.btnLogoutProfileCustomer)

        btnEdit.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameCustomer, CustomerEditProfileFragment())
                .addToBackStack(null)
                .commit()
        }

        btnTransactions.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameCustomer, CustomerReservationsFragment())
                .addToBackStack(null)
                .commit()
        }

        btnLogout.setOnClickListener {
            ioScope.launch {
                db.userDAO.clear()
            }
            val intent = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intent)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(customer: Customer) =
            CustomerProfileFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                }
            }
    }
}