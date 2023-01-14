package acid.istts.parkremobile.activities.shared.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.ActivityAdminMasterCustomerBinding
import acid.istts.parkremobile.databinding.ActivityMainBinding
import acid.istts.parkremobile.services.ServiceLocator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acid.istts.parkremobile.R
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import kotlin.math.log

class admin_master_customer : Fragment() {
class admin_master_customer : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var binding : ActivityAdminMasterCustomerBinding
    val user = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.sidebar_view)
        toolbar = findViewById(R.id.toolbar2)


        binding = ActivityAdminMasterCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: change into custom list view
        //TODO: add detail button
        //TODO: detail button clicked -> open customer detail
        val userAdapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,user)
        binding.userList.adapter = userAdapter

        val serviceLocator = ServiceLocator.getInstance()

        serviceLocator.getCustomerRepository().fetchCustomers(context = this, onSuccess = {
            val obj = JSONObject(it)
            val status = obj.getString("status")
            val data = obj.getJSONArray("data")

            if (status == "success") {
                for (i in 0 until data.length()) {
                    val customerObj = data.getJSONObject(i)
                    //FIXME: change into customer model instead of string
                    val customer = customerObj.getString("name")
                    user.add(customer)
                }
            }

            userAdapter.notifyDataSetChanged()
        }, onError = {
            Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        })

//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                binding.searchView.clearFocus()
//                if (user.contains(query)){
//                    userAdapter.filter.filter(query)
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                userAdapter.filter.filter(newText)
//                return false
//            }
//
//        })

        setSupportActionBar(toolbar)

        navigationView.bringToFront()
        var toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_master_customer, container, false)
    }
}