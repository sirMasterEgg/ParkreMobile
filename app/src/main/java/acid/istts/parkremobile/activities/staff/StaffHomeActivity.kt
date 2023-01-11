package acid.istts.parkremobile.activities.staff

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.ActivityStaffHomeBinding
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.models.Reservation
import acid.istts.parkremobile.services.ServiceLocator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import org.json.JSONObject

class StaffHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStaffHomeBinding
    private lateinit var annAdapter: AnnouncementAdapter
    private lateinit var resAdapter: ReservationAdapter

    var annList : ArrayList<Announcement> = ArrayList()
    var resList : ArrayList<Reservation> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaffHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       val serviceLocator = ServiceLocator.getInstance()

        serviceLocator.getAnnouncementRepository().fetchAnnouncementByMallId(0, context = this, onSuccess = {
            val obj = JSONObject(it)
            val status = obj.getString("status")
            val data = obj.getJSONArray("data")

            if (status == "success") {
                for (i in 0 until data.length()) {
                    val ann = data.getJSONObject(i)
                    val id = ann.getInt("id")
                    val header = ann.getString("header")
                    val content = ann.getString("content")
                    val status = ann.getInt("status")
                    val mall_id = ann.getInt("mall_id")
                    val staff_id = ann.getInt("staff_id")
                    val announcement = Announcement(id, header, content, status, mall_id, staff_id)
                    annList.add(announcement)
                }
                annAdapter = AnnouncementAdapter(annList)
                swapToFrag(AnnouncementFragment(annAdapter))
            } else {
                Toast.makeText(this, "Failed to fetch announcement", Toast.LENGTH_SHORT).show()
            }
        }, onError = {
            Toast.makeText(this, "Failed to fetch announcement", Toast.LENGTH_SHORT).show()
        })

        swapToFrag(HomeFragment(resAdapter))

        var drawerLayout = binding.drawerLayout
        var navView = binding.navStaff
        var toolbar = binding.toolbar

        navView.bringToFront()
        setSupportActionBar(toolbar)

        val toggle : ActionBarDrawerToggle = ActionBarDrawerToggle(this@StaffHomeActivity, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navStaff.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    swapToFrag(HomeFragment(resAdapter))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.menu_announcement -> {
                    swapToFrag(AnnouncementFragment(annAdapter))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) binding.drawerLayout.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }

    private fun swapToFrag(fragment: Fragment) {
        val bundle = Bundle()
        fragment.arguments = bundle

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(R.id.mainFragment, fragment)
        fragmentManager.commit()
    }
}