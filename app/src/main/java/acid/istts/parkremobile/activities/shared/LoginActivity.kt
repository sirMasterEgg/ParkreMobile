package acid.istts.parkremobile.activities.shared

import acid.istts.parkremobile.databinding.ActivityLoginBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}