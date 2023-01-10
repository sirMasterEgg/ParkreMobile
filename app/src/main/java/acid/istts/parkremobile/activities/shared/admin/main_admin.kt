package acid.istts.parkremobile.activities.shared.admin

import acid.istts.parkremobile.R
import acid.istts.parkremobile.databinding.FragmentMainAdmin1Binding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class main_admin : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var fragment_main_admin1 : main_admin1
    lateinit var admin_master_announcement1 : admin_master_announcement1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_admin)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.sidebar_view)
        toolbar = findViewById(R.id.toolbar2)
        fragment_main_admin1 = main_admin1()
        admin_master_announcement1 = admin_master_announcement1()

        setSupportActionBar(toolbar)

        navigationView.bringToFront()
        var toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        gantihalaman()
        gantihalamanannounce()


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
        gantiframe.replace(R.id.admin_bagian_main,fragment_main_admin1)
        gantiframe.commit()
    }

    fun gantihalamanannounce(){
        val gantiframe = supportFragmentManager.beginTransaction()
        gantiframe.replace(R.id.admin_bagian_main,admin_master_announcement1)
        gantiframe.commit()
    }



}