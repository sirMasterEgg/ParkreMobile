package acid.istts.parkremobile.activities.shared.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.ActivityAdminMasterCustomerBinding
import acid.istts.parkremobile.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class admin_master_customer : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var binding : ActivityAdminMasterCustomerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_master_customer)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.sidebar_view)
        toolbar = findViewById(R.id.toolbar2)


        binding = ActivityAdminMasterCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = arrayOf("jason","victor","nich","lele","daniel","mikel","sinyo ganteng")
        val userAdapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,user)

        binding.userList.adapter = userAdapter

//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                binding.searchView.clearFocus()
//                if (user.contains(query)){
//                    userAdapter.filter.filter(query)
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                userAdapter.filter.filter(newText)
//                return false
//            }
//
//        })

        setSupportActionBar(toolbar)

        navigationView.bringToFront()
        var toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


    }

    override fun onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}