package acid.istts.parkremobile.activities.shared

import acid.istts.parkremobile.activities.customer.CustomerHomeActivity
import acid.istts.parkremobile.databinding.ActivityLoginBinding
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.services.ServiceLocator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONArray

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val ioScope = CoroutineScope(Dispatchers.IO)

        val serviceLocator = ServiceLocator.getInstance()
        val email = binding.etEmailLogin.text.toString()
        val password = binding.etPasswordLogin.text.toString()
        var customer : Customer? = null
        binding.btnLogin.setOnClickListener {
            val strReq = serviceLocator.getCustomerRepository().login(email, password){
                println(it)
//                val obj = JSONArray(it)
//                if (obj.length() > 0){
//                    val customerObj = obj.getJSONObject(0)
//                    customer = Customer(
//                        customerObj.getInt("id"),
//                        customerObj.getString("name"),
//                        customerObj.getString("email"),
//                        customerObj.getString("password"),
//                        customerObj.getString("phone"),
//                        customerObj.getString("address"),
//                    )
//                }
            }
            val queue : RequestQueue = Volley.newRequestQueue(view.context)
            queue.add(strReq)
            if (customer != null){
                Intent(this, CustomerHomeActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }else{
                Toast.makeText(view.context, "not found", Toast.LENGTH_SHORT).show()
            }

        }
    }
}