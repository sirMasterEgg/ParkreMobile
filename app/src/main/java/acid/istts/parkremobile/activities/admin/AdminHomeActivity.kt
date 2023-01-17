package acid.istts.parkremobile.activities.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.adapters.admin.CustomerAdapter
import acid.istts.parkremobile.adapters.admin.StaffAdapter
import acid.istts.parkremobile.fragments.admin.*
import acid.istts.parkremobile.models.Customer
import acid.istts.parkremobile.models.Staff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

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
    lateinit var framelayoutadmin : FrameLayout
    lateinit var sidebarview : NavigationView

    private lateinit var customerAdapter : CustomerAdapter
    private lateinit var staffAdapter : StaffAdapter

    var customerList : ArrayList<Customer> = ArrayList()
    var staffList : ArrayList<Staff> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.sidebar_view)
        toolbar = findViewById(R.id.toolbar2)
        framelayoutadmin = findViewById(R.id.framelayoutadmin)
        sidebarview = findViewById(R.id.sidebar_view)
        fragment_main_admin1 = AdminHomeFragment()
        admin_master_announcement = AdminMasterAnnouncementFragment()
//        admin_master_customer = AdminMasterCustomerFragment()
//        admin_master_staff = AdminMasterStaffFragment()
        admin_master_mall = AdminMasterMallFragment()
        admin_add_staff = AdminAddStaffFragment()
        admin_add_announcement = AdminAddAnnouncementFragment()
        admin_add_job = AdminAddJobFragment()

        customerList.add(Customer(0, "Customer 1", "pass", "@mail", "1234567890", "address", "city"))
        customerList.add(Customer(1, "Customer 2", "pass", "@mail", "1234567890", "address", "city"))
        customerList.add(Customer(2, "Customer 3", "pass", "@mail", "1234567890", "address", "city"))
        customerList.add(Customer(3, "Customer 4", "pass", "@mail", "1234567890", "address", "city"))

        staffList.add(Staff(0, "Staff 1", "Staff 1", "@mail", "1234567890", "address", 2, "staff"))
        staffList.add(Staff(1, "Staff 2", "Staff 2", "@mail", "1234567890", "address", 2, "staff"))
        staffList.add(Staff(2, "Staff 3", "Staff 3", "@mail", "1234567890", "address", 2, "staff"))
        staffList.add(Staff(3, "Staff 4", "Staff 4", "@mail", "1234567890", "address", 2, "staff"))

        customerAdapter = CustomerAdapter(customerList)
        staffAdapter = StaffAdapter(staffList)

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
//                    gantihalamancustomer()

                    swapToFrag(AdminMasterCustomerFragment(customerAdapter, "token"))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.sidebar_master_staff->{
//                    gantihalamanstaff()

                    swapToFrag(AdminMasterStaffFragment(staffAdapter))
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

    private fun swapToFrag(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayoutadmin, fragment)
        transaction.commit()
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
}