package acid.istts.parkremobile.activities.shared

import acid.istts.parkremobile.activities.customer.CustomerHomeActivity
import acid.istts.parkremobile.databinding.ActivityLoginBinding
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.services.ServiceLocator
import android.content.Intent
import android.os.Bundle
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
        var customer : Customer? = null

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmailLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()

            val strReq = serviceLocator.getCustomerRepository().login(email, password) {
                val obj = JSONObject(it)
                val status = obj.getString("status")

                if (status == "success") {
                    val token = obj.getString("token")
                    val customerObj = obj.getJSONObject("data")
                    customer = Customer(
                        customerObj.getInt("id"),
                        customerObj.getString("name"),
                        customerObj.getString("email"),
                        customerObj.getString("password"),
                        customerObj.getString("phone"),
                        customerObj.getString("address"),
                    )

                    ioScope.launch {
                        //TODO: save token and customer data into database
                    }

                }

                if (customer != null) {
                    Intent(this@LoginActivity, CustomerHomeActivity::class.java).apply {
                        startActivity(this@apply)
                        finish()
                    }
                } else {
                    Toast.makeText(view.context, "Login Failed!", Toast.LENGTH_SHORT).show()
                }
            }

            val queue : RequestQueue = Volley.newRequestQueue(view.context)
            queue.add(strReq)

        }
    }
}