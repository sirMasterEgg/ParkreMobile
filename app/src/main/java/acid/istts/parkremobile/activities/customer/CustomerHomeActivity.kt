package acid.istts.parkremobile.activities.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.ActivityCustomerHomeBinding
import acid.istts.parkremobile.fragments.customer.*
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.services.AppDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // demo customer
//        val customer = Customer(
//            99,
//            "John Doe",
//            "",
//            "johndoe@gmail.com",
//            "08123456789",
//            "Random Street 123"
//        )
        val announcement = Announcement(
            1,
            "Announcement 1",
            "This is a demo announcement",
            1,
            2,
            21,
            "tes"
        )

        // get customer
        val customer = intent.getParcelableExtra<Customer>("customer")!!

        val db = AppDatabase.build(this)
        val ioScope = CoroutineScope(Dispatchers.IO)
        ioScope.launch {
            customer.token = db.userDAO.getToken()!!
        }

        startCustomer(customer)
        binding.bottomReserve.setOnClickListener {
            binding.bottomNavigationView.selectedItemId = R.id.bottom_home
            CustomerReserveFragment.newInstance("tes", "tes").apply {
                supportFragmentManager.beginTransaction()
                    .replace(binding.frameCustomer.id, this)
                    .commit()
            }
        }

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_home -> {
                    CustomerHomeFragment.newInstance(customer).apply {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.frameCustomer.id, this)
                            .commit()
                    }
                    true
                }
                R.id.bottom_announcements -> {
                    CustomerAnnouncementsFragment.newInstance().apply {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.frameCustomer.id, this)
                            .commit()
                    }
                    true
                }
                R.id.bottom_vehicles -> {
                    CustomerVehiclesFragment.newInstance(customer).apply {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.frameCustomer.id, this)
                            .commit()
                    }
                    true
                }
                R.id.bottom_profile -> {
                    CustomerProfileFragment.newInstance(customer).apply {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.frameCustomer.id, this)
                            .commit()
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun startCustomer(customer: Customer){
        CustomerHomeFragment.newInstance(customer).apply {
            supportFragmentManager.beginTransaction()
                .replace(binding.frameCustomer.id, this)
                .commit()
        }
    }
}