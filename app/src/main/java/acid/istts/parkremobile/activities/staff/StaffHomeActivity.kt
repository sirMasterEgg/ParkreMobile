package acid.istts.parkremobile.activities.staff

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.ActivityStaffHomeBinding
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.models.Reservation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment

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

        annList.add(Announcement(1, "Announcement Pertama",
            "Ini adalah Announcement Pertama", 1, 1, 1))
        annList.add(Announcement(2, "Announcement Kedua",
            "Ini adalah Announcement Kedua", 1, 1, 1))
        annList.add(Announcement(3, "Announcement Ketiga",
            "Ini adalah Announcement Ketiga", 1, 1, 1))

        resList.add(Reservation(1, "22:10", "04.15", 1, 1, "2022-12-31", 1, 1, 1))
        resList.add(Reservation(2, "22:10", "04.15", 1, 1, "2022-12-31", 1, 1, 1))
        resList.add(Reservation(3, "22:10", "04.15", 1, 1, "2022-12-31", 1, 1, 1))

        annAdapter = AnnouncementAdapter(annList)
        resAdapter = ReservationAdapter(resList)

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