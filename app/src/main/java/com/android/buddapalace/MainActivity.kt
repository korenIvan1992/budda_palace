package com.android.buddapalace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.buddapalace.ui.allglobal.extentions.makeGone
import com.android.buddapalace.ui.allglobal.extentions.makeVisible
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var navController: NavController
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView = nav_view
        bottomNavigationView.setupWithNavController(navController)
    }

    fun setStateBackGround(state: Boolean) {
        if (!state)
            background_header.makeGone()
        else
            background_header.makeVisible()
    }

    fun openFragment(id: Int) {
        navController.navigate(id)
    }
}