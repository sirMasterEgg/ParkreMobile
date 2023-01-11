package acid.istts.parkremobile.activities.customer

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.ActivityCustomerHomeBinding
import acid.istts.parkremobile.fragments.customer.*
import acid.istts.parkremobile.models.Customer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CustomerHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // demo customer
        val demoCustomer = Customer(
            99,
            "John Doe",
            "",
            "johndoe@gmail.com",
            "08123456789",
            "Random Street 123"
        )

        // get customer
        val customer = intent.getParcelableExtra<Customer>("customer")

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
                    CustomerHomeFragment.newInstance(demoCustomer).apply {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.frameCustomer.id, this)
                            .commit()
                    }
                    true
                }
                R.id.bottom_search -> {
                    CustomerSearchFragment.newInstance("tes", "tes").apply {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.frameCustomer.id, this)
                            .commit()
                    }
                    true
                }
                R.id.bottom_vehicles -> {
                    CustomerVehiclesFragment.newInstance("tes", "tes").apply {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.frameCustomer.id, this)
                            .commit()
                    }
                    true
                }
                R.id.bottom_profile -> {
                    CustomerProfileFragment.newInstance("tes", "tes").apply {
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
}