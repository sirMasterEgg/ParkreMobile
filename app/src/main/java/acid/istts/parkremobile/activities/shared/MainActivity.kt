package acid.istts.parkremobile.activities.shared

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.ActivityMainBinding
import acid.istts.parkremobile.fragments.onboarding.OnBoarding1Fragment
import acid.istts.parkremobile.fragments.onboarding.OnBoarding2Fragment
import acid.istts.parkremobile.fragments.onboarding.OnBoarding3Fragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var state = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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