package acid.istts.parkremobile.activities.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.activities.shared.LoginActivity
import acid.istts.parkremobile.adapters.admin.AnnoucementAdapter
import acid.istts.parkremobile.adapters.staff.AnnouncementAdapter
import acid.istts.parkremobile.fragments.admin.*
import acid.istts.parkremobile.models.Announcement
import acid.istts.parkremobile.services.AppDatabase
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AdminHomeActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var fragment_main_admin1 : AdminHomeFragment
    lateinit var admin_master_announcement : AdminMasterAnnouncementFragment
    lateinit var admin_master_customer : AdminMasterCustomerFragment
    lateinit var admin_master_mall : AdminMasterMallFragment
    lateinit var admin_master_staff : AdminMasterStaffFragment
    lateinit var admin_add_staff : AdminAddStaffFragment
    lateinit var admin_add_announcement : AdminAddAnnouncementFragment
    lateinit var admin_add_job : AdminAddJobFragment
    lateinit var admin_add_mall : AdminAddMallFragment
    lateinit var framelayoutadmin : FrameLayout
    lateinit var sidebarview : NavigationView

    lateinit var admin_detail_mall : AdminMallDetailFragment
    lateinit var admin_detail_announcement : AdminAnnouncementDetail

    val ioScope = CoroutineScope(Dispatchers.IO)
    val db = AppDatabase.build(this)

    private lateinit var annAdapter: AnnoucementAdapter
    var annListadmin : ArrayList<Announcement> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        var token: String? = null
        runBlocking {
            token = db.userDAO.getToken()
        }

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.sidebar_view)
        toolbar = findViewById(R.id.toolbar2)
        framelayoutadmin = findViewById(R.id.framelayoutadmin)
        sidebarview = findViewById(R.id.sidebar_view)
        fragment_main_admin1 = AdminHomeFragment()
        admin_master_announcement = AdminMasterAnnouncementFragment()
        admin_master_customer = AdminMasterCustomerFragment()
        admin_master_staff = AdminMasterStaffFragment()
        admin_master_mall = AdminMasterMallFragment()
        admin_add_staff = AdminAddStaffFragment()
        admin_add_announcement = AdminAddAnnouncementFragment()
        admin_add_job = AdminAddJobFragment()
        admin_add_mall = AdminAddMallFragment()
        admin_detail_mall = AdminMallDetailFragment()
        admin_detail_announcement = AdminAnnouncementDetail()

        setSupportActionBar(toolbar)

        navigationView.bringToFront()
        var toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        sidebarview.setNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.sidebar_home->{
                    gantihalaman()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.sidebar_master_customer->{
                    gantihalamancustomer()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.sidebar_master_staff->{
                    gantihalamanstaff()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.sidebar_master_mall->{
                    gantihalamanmall()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.sidebar_master_announcement->{
                    gantihalamanannounce()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.sidebar_logout->{
                    ioScope.launch {
                        db.userDAO.clear()
                    }
                    val req = object : StringRequest(
                        Method.POST, "https://parkre.loca.lt/api/logout", Response.Listener {},
                        Response.ErrorListener {
                        println("====================================")
                        println(String(it.networkResponse.data, Charsets.UTF_8))
                    }){
                        override fun getHeaders(): MutableMap<String, String> {
                            val headers = HashMap<String, String>()
                            headers["Authorization"] = token!!
                            headers["Accept"] = "application/json"
                            return headers
                        }
                    }
                    val queue : RequestQueue = Volley.newRequestQueue(this)
                    queue.add(req)

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }



    }
    override fun onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun gantihalaman(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,fragment_main_admin1)
        gantiframe.commit()
    }

    fun gantihalamanannounce(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_master_announcement)
        gantiframe.commit()
    }

    fun gantihalamancustomer(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_master_customer)
        gantiframe.commit()
    }

    fun gantihalamanmall(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_master_mall)
        gantiframe.commit()
    }

    fun gantihalamanstaff(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_master_staff)
        gantiframe.commit()
    }

    fun gantihalamanaddstaff(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_add_staff)
        gantiframe.commit()
    }

    fun gantihalamanaddannouncement(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_add_announcement)
        gantiframe.commit()
    }

    fun gantihalamanaddjob(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_add_job)
        gantiframe.commit()
    }

    fun gantihalamanaddmall(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_add_mall)
        gantiframe.commit()
    }

    fun gantihalamandetaiannouncement(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.framelayoutadmin,admin_detail_announcement)
        gantiframe.commit()
    }
}