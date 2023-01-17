package acid.istts.parkremobile.fragments.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.customer.MallAdapter
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.models.Mall
import acid.istts.parkremobile.services.AppDatabase
import acid.istts.parkremobile.services.ServiceLocator
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "customer"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomerReserveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomerReserveFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var customer: Customer? = null
    private val malls = ArrayList<Mall>()

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
        return inflater.inflate(R.layout.fragment_customer_reserve, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMallSearch = view.findViewById<RecyclerView>(R.id.rvMallSearch)
        val searchMall = view.findViewById<SearchView>(R.id.searchViewReserve)

        val adapter = MallAdapter(malls, onItemClickListener = {
            val customerMallDetail = CustomerMallDetailFragment.newInstance(customer!!, it)
            parentFragmentManager.beginTransaction().replace(R.id.frameCustomer, customerMallDetail).commit()
        })
        val layout = GridLayoutManager(context, 2)
        rvMallSearch.layoutManager = layout
        rvMallSearch.adapter = adapter

        val serviceLocator = ServiceLocator.getInstance()
        serviceLocator.getMallRepository().fetchMalls(context = view.context, onSuccess = {
            malls.clear()
            val response = JSONObject(it)
            val data = response.getJSONArray("data")
            for (i in 0 until data.length()) {
                val mall = data.getJSONObject(i)
                malls.add(Mall(
                    id = mall.getInt("id"),
                    name = mall.getString("name"),
                    slug = mall.getString("slug"),
                    address = mall.getString("address"),
                    image_url = if (mall.isNull("image_url")) "" else mall.getString("image_url"),
                    park_space = mall.getInt("park_space"),
                    reserve_space = mall.getInt("reserve_space"),
                    available_space = mall.getInt("park_space") - mall.getInt("reserve_space"),
                ))
            }
            adapter.notifyDataSetChanged()
        }, onError = {

        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CustomerReserveFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Customer) =
            CustomerReserveFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }
}