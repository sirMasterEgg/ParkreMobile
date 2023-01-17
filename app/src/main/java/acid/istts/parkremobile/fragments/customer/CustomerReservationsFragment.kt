package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.customer.ReservationAdapter
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.models.Transaction
import acid.istts.parkremobile.services.ServiceLocator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "customer"

class CustomerReservationsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_customer_reservations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val serviceLocator = ServiceLocator.getInstance()
        val transactions: ArrayList<Transaction> = ArrayList()

        transactions.add(
            Transaction(
            id = 1,
            price = 5000,
            mall_name = "Mall 1",
            date = "2020-01-01",
            )
        )
        transactions.add(Transaction(
            id = 2,
            price = 10000,
            mall_name = "Mall 2",
            date = "2020-01-05",
        ))

        val reservationAdapter = ReservationAdapter(transactions)
        val rvReservations = view.findViewById<RecyclerView>(R.id.rvReservations)
        rvReservations.adapter = reservationAdapter
        rvReservations.layoutManager = LinearLayoutManager(view.context)
    }

    companion object {
        @JvmStatic
        fun newInstance(customer: Customer) =
            CustomerReservationsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                }
            }
    }
}