package acid.istts.parkremobile.activities.staff

import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.staff.AnnouncementAdapter
import acid.istts.parkremobile.adapters.staff.ReservationAdapter
import acid.istts.parkremobile.databinding.ActivityStaffHomeBinding
import acid.istts.parkremobile.fragments.staff.StaffAnnouncementFragment
import acid.istts.parkremobile.fragments.staff.StaffHomeFragment
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.models.Reservation
import acid.istts.parkremobile.services.AppDatabase
import acid.istts.parkremobile.services.ServiceLocator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import org.json.JSONObject

class StaffHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStaffHomeBinding
    private lateinit var annAdapter: AnnouncementAdapter
    private lateinit var resAdapter: ReservationAdapter
    val ioScope = CoroutineScope(Dispatchers.IO)
    val db = AppDatabase.build(this)


    var annList : ArrayList<Announcement> = ArrayList()
    var resList : ArrayList<Reservation> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaffHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var token: String? = null
        runBlocking {
            token = db.userDAO.getToken()
        }

        annAdapter = AnnouncementAdapter(annList)
        val serviceLocator = ServiceLocator.getInstance()

        serviceLocator.getAnnouncementRepository().fetchAnnouncementByMallId(context = this, onSuccess = {
            val obj = JSONObject(it)
            val status = obj.getString("status")
            val data = obj.getJSONArray("announcements")

            if (status == "success") {
                for (i in 0 until data.length()) {
                    val ann = data.getJSONObject(i)
                    val id = ann.getInt("id")
                    val header = ann.getString("header")
                    val content = ann.getString("content")
                    val status = ann.getInt("status")
                    val mall_id = ann.getInt("mall_id")
                    val staff_id = ann.getInt("staff_id")
                    val mall_name = ann.getString("mall_name")
                    val announcement = Announcement(id, header, content, status, mall_id, staff_id, mall_name)
                    annList.add(announcement)
                }
                annAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Failed to fetch announcement", Toast.LENGTH_SHORT).show()
            }
        }, onError = {
            Toast.makeText(this, "Failed to fetch announcement", Toast.LENGTH_SHORT).show()
        },
            token = token!!
        )



        resAdapter = ReservationAdapter(resList)
        serviceLocator.getReservationRepository().fetchReservations(context = this, onSuccess = {
            val obj = JSONObject(it)
            val status = obj.getString("status")
            val data = obj.getJSONArray("reservations")

            if (status == "success") {
                for (i in 0 until data.length()) {
                    val res = data.getJSONObject(i)
                    val reservation = Reservation(
                        id = res.getInt("id"),
                        start_time = res.getString("start_time"),
                        end_time = res.getString("end_time"),
                        price = res.getInt("price"),
                        status = res.getInt("status"),
                        date = res.getString("date"),
                        user_id = res.getInt("user_id"),
                        vehicle_id = res.getInt("vehicle_id"),
                        segmentation_id = res.getInt("segmentation_id"),
                        user_name = res.getString("user_name"),
                        vehicle_plate = res.getString("vehicle_plate"),
                        segmentation_name = res.getString("segmentation_name"),
                        mall_name = res.getString("mall_name")
                    )
                    resList.add(reservation)
                }
                resAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Failed to fetch reservation", Toast.LENGTH_SHORT).show()
            }
        }, onError = {
            Toast.makeText(this, "Failed to fetch reservation", Toast.LENGTH_SHORT).show()
        },
            token = token!!
        )

        var drawerLayout = binding.drawerLayout
        var navView = binding.navStaff
        var toolbar = binding.toolbar

        navView.bringToFront()
        setSupportActionBar(toolbar)

        val toggle : ActionBarDrawerToggle = ActionBarDrawerToggle(this@StaffHomeActivity, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        swapToFrag(StaffHomeFragment(resAdapter))

        binding.navStaff.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    resAdapter.notifyDataSetChanged()
                    swapToFrag(StaffHomeFragment(resAdapter))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.menu_announcement -> {
                    annAdapter.notifyDataSetChanged()
                    swapToFrag(StaffAnnouncementFragment(
                        annAdapter))
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