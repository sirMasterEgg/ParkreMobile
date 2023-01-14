package acid.istts.parkremobile.activities.shared

import acid.istts.parkremobile.activities.customer.CustomerHomeActivity
import acid.istts.parkremobile.activities.staff.StaffHomeActivity
import acid.istts.parkremobile.databinding.ActivityLoginBinding
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.models.Staff
import acid.istts.parkremobile.models.UserEntity
import acid.istts.parkremobile.services.AppDatabase
import acid.istts.parkremobile.services.ServiceLocator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val ioScope = CoroutineScope(Dispatchers.IO)

        val serviceLocator = ServiceLocator.getInstance()
        val db = AppDatabase.build(this)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmailLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()

            // log in as customer
            if (email.contains("@")){
                val strReq = serviceLocator.getCustomerRepository().login(email, password) {
                    val obj = JSONObject(it)
                    val status = obj.getString("status")

                    var customer : Customer? = null
                    if (status == "success") {
                        val token = obj.getString("token")
                        val customerObj = obj.getJSONObject("data")
                        customer = Customer(
                            id = customerObj.getInt("id"),
                            name = customerObj.getString("name"),
                            email = customerObj.getString("email"),
                            password = customerObj.getString("password"),
                            phone = customerObj.getString("phone"),
                            address = customerObj.getString("address"),
                            token = token
                        )

                        ioScope.launch {
                            if(db.userDAO.getCount() == 0){
                                db.userDAO.insert(
                                    UserEntity(
                                        db_id = customer.id,
                                        token = token,
                                        role = 1
                                    )
                                )
                            } else {
                                db.userDAO.setValues(customer.id, token, 1)
                            }
                        }

                    }

                    if (customer != null) {
                        val intent = Intent(this@LoginActivity, CustomerHomeActivity::class.java)
                        intent.putExtra("customer", customer)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(view.context, "Login Failed!!", Toast.LENGTH_SHORT).show()
                    }
                }

                val queue : RequestQueue = Volley.newRequestQueue(view.context)
                queue.add(strReq)
            }
            // login as staff or admin
            else{
                val strReq = serviceLocator.getStaffRepository().login(email, password) {
//                    Log.e("it", it)
//                    val staff = null
                    val obj = JSONObject(it)
                    val status = obj.getString("status")

                    var staff: Staff? = null
                    if (status == "success") {
                        val token = obj.getString("token")
                        val staffObj = obj.getJSONObject("data")
                        staff = Staff(
                            id = staffObj.getInt("id"),
                            username = staffObj.getString("username"),
                            name = staffObj.getString("name"),
                            password = staffObj.getString("password"),
                            phone = staffObj.getString("phone"),
                            address = staffObj.getString("address"),
                            role_id = staffObj.getInt("role_id"),
                            role_name = null
                        )

                        ioScope.launch {
                            if(db.userDAO.getCount() == 0){
                                db.userDAO.insert(
                                    UserEntity(
                                        db_id = staff.id,
                                        token = token,
                                        role = staff.role_id + 1
                                    )
                                )
                            } else {
                                db.userDAO.setValues(staff.id, token, staff.role_id + 1)
                            }
                        }

                    }

                    if (staff != null) {
//                        TODO: add staff to activity
                        val intent = Intent(this@LoginActivity, StaffHomeActivity::class.java)
//                        intent.putExtra("customer", customer)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(view.context, "Login Failed!!", Toast.LENGTH_SHORT).show()
                    }
                }

                val queue : RequestQueue = Volley.newRequestQueue(view.context)
                queue.add(strReq)
            }

        }

        binding.btnRegisterLogin.setOnClickListener {
            Intent(this@LoginActivity, RegisterActivity::class.java).apply {
                startActivity(this@apply)
            }
        }
    }
}