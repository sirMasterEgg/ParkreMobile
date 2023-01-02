package acid.istts.parkremobile.activities.shared

import acid.istts.parkremobile.activities.customer.CustomerHomeActivity
import acid.istts.parkremobile.databinding.ActivityRegisterBinding
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


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val ioScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val serviceLocator = ServiceLocator.getInstance()

        binding.btnRegister.setOnClickListener {
            val email: String = "mbokmu@mail.com"
            val password: String = "qwe"
            val passwordConfirmation: String = "qwe"
            val name: String = "MuhammadBokmu"
            val phone: String = "081234567890"
            val address: String = "Jl. Jalan"

            val stringReq = serviceLocator.getCustomerRepository().register(email, password, passwordConfirmation, name, phone, address, onSuccess =  {
                val obj = JSONObject(it)
                val status = obj.getString("status")
                if (status == "success") {
                    val token = obj.getString("token")
                    val customerObj = obj.getJSONObject("data")
                    val customer = Customer(
                        customerObj.getInt("id"),
                        customerObj.getString("name"),
                        customerObj.getString("email"),
                        customerObj.getString("password"),
                        customerObj.getString("phone"),
                        customerObj.getString("address"),
                    )

                    ioScope.launch {
                        // TODO: save token and customer data into database
                    }

                    Intent(this@RegisterActivity, CustomerHomeActivity::class.java).apply {
                        startActivity(this@apply)
                    }
                }
            }, onError = {
                val errors = String(it.networkResponse.data, Charsets.UTF_8)
                val obj = JSONObject(errors)
                val status = obj.getString("status")

                if (status == "error") {
                    val messages = obj.getJSONObject("message")
                    for (key in messages.keys()) {
                        val message = messages.getJSONArray(key)
                        for (i in 0 until message.length()) {
                            println("$key: ${message[i]}")
                        }
                    }
                    Toast.makeText(this@RegisterActivity, "Register failed!", Toast.LENGTH_SHORT).show()
                }
            })

            val queue : RequestQueue = Volley.newRequestQueue(view.context)
            queue.add(stringReq)

        }

    }
}