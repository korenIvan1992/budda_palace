package com.android.buddhapalace.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.buddhapalace.quotes.ui.allglobal.extentions.makeGone
import com.android.buddhapalace.quotes.ui.allglobal.extentions.makeVisible
import com.android.buddhapalace.quotes.ui.allglobal.extentions.toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    var stateBackPressed = true
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

     fun onBackPressedLast() {
         if(!stateBackPressed)
             finish()
         else {
             toast("Нажмите еще раз если хотите выйти")
             stateBackPressed = false
             CoroutineScope(Dispatchers.IO).launch {
                 delay(2000)
                 stateBackPressed = true
             }
         }
    }
}