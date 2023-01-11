package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.models.Customer

private const val ARG_PARAM1 = "customer"

class CustomerMallDetailFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_customer_mall_detail, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(customer: Customer) =
            CustomerMallDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, customer)
                }
            }
    }
}