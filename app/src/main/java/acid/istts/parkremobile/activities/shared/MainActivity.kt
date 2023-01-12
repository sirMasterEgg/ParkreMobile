package acid.istts.parkremobile.activities.shared

import acid.istts.parkremobile.R
import acid.istts.parkremobile.activities.customer.CustomerHomeActivity
import acid.istts.parkremobile.databinding.ActivityMainBinding
import acid.istts.parkremobile.fragments.onboarding.OnBoarding1Fragment
import acid.istts.parkremobile.fragments.onboarding.OnBoarding2Fragment
import acid.istts.parkremobile.fragments.onboarding.OnBoarding3Fragment
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.services.AppDatabase
import acid.istts.parkremobile.services.ServiceLocator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private lateinit var ioScope : CoroutineScope
    private var state = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = AppDatabase.build(this)
        // check if user has logged in
        ioScope = CoroutineScope(Dispatchers.IO)
        ioScope.launch {
            if (db.userDAO.getDBId() != null){
                val serviceLocator = ServiceLocator.getInstance()
                val dbId = db.userDAO.getDBId()!!
                when(db.userDAO.getRole()){
                    1 -> {
                        val customer = serviceLocator.getCustomerRepository().getCustomer(id = dbId,
                            onSuccess = {
                                val customerObj = JSONObject(it).getJSONObject("data")
                                val activeCustomer = Customer(
                                    id = customerObj.getInt("id"),
                                    name = customerObj.getString("name"),
                                    email = customerObj.getString("email"),
                                    password = customerObj.getString("password"),
                                    phone = customerObj.getString("phone"),
                                    address = customerObj.getString("address"),
                                    token = customerObj.getString("token")
                                )
                                val intent = Intent(this@MainActivity, CustomerHomeActivity::class.java)
                                intent.putExtra("customer", activeCustomer)
                                startActivity(intent)
                                finish()
                            },
                            onError = {
                                Toast.makeText(this@MainActivity, "Error: $it", Toast.LENGTH_SHORT).show()
                            },
                            context = view.context)
                        if (customer != null){
                            val intent = Intent(this@MainActivity, CustomerHomeActivity::class.java)
                            intent.putExtra("customer", customer)
                            startActivity(intent)
                            finish()
                        }
                    }
                    2 ->{
                        val admin = serviceLocator.getStaffRepository().getStaff(dbId)
                    }
                    3 ->{
                        val staff = serviceLocator.getStaffRepository().getStaff(dbId)
                    }
                }
            }

        }

        OnBoarding1Fragment.newInstance().apply { swapToFrag(this) }
        binding.btnOnboarding.setOnClickListener{
        when (state) {
                0 -> {
                    OnBoarding2Fragment.newInstance().apply { swapToFrag(this) }
                    state += 1
                }
                1 -> {
                    OnBoarding3Fragment.newInstance().apply { swapToFrag(this) }
                    state += 1
                    binding.btnOnboarding.text = getString(R.string.btnOnboarding)
                }
                2 -> {
                    Intent(this, LoginActivity::class.java).apply {
                        startActivity(this)
                        finish()
                    }
                }
            }
        }
    }

    private fun swapToFrag(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.frameOnboarding.id, fragment)
        transaction.commit()
    }
}