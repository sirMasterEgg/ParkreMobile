package acid.istts.parkremobile.activities.shared.admin

import acid.istts.parkremobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_admin)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.sidebar_view)
        toolbar = findViewById(R.id.toolbar2)

        setSupportActionBar(toolbar)

        navigationView.bringToFront()
        var toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

//        navigationView.setNavigationItemSelectedListener(this);

    }

    override fun onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    fun onNavigationItemSelected(@NonNull menuItem: java.awt.MenuItem): Boolean {
//        when (menuItem.getItemId()) {
//            R.id.nav_home -> {}
//            R.id.nav_bus -> {
//                val intent = Intent(this@main_admin, Bus::class.java)
//                startActivity(intent)
//            }
//            R.id.nav_login -> {
//                java.awt.SystemColor.menu.findItem(R.id.nav_logout).setVisible(true)
//                java.awt.SystemColor.menu.findItem(R.id.nav_profile).setVisible(true)
//                java.awt.SystemColor.menu.findItem(R.id.nav_login).setVisible(false)
//            }
//            R.id.nav_logout -> {
//                java.awt.SystemColor.menu.findItem(R.id.nav_logout).setVisible(false)
//                java.awt.SystemColor.menu.findItem(R.id.nav_profile).setVisible(false)
//                java.awt.SystemColor.menu.findItem(R.id.nav_login).setVisible(true)
//            }
//            R.id.nav_share -> Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
//        }
//        drawerLayout.closeDrawer(GravityCompat.START)
//        return true
//    }


}