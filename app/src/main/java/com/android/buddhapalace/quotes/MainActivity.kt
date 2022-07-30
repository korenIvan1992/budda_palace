package com.android.buddhapalace.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.android.buddhapalace.quotes.ui.favorites.FavoritesFragment
import com.android.buddhapalace.quotes.ui.quotes.QuotesFragment
import com.android.buddhapalace.quotes.ui.settings.SettingsFragments
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        const val QUOTES = "QuotesFragment"
        const val FAVORITES = "FavoritesFragment"
        const val SETTINGS = "SettingsFragments"
    }

    lateinit var navController: NavController

    private val settingsFragments by lazy { SettingsFragments() }
    private val favoritesFragment by lazy { FavoritesFragment() }
    private val quotesFragment by lazy { QuotesFragment() }

    private var activeFragment: Fragment = quotesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container_header_fragment, settingsFragments, SETTINGS).hide(settingsFragments)
            add(R.id.container_header_fragment, favoritesFragment, FAVORITES).hide(favoritesFragment)
            add(R.id.container_header_fragment, quotesFragment, QUOTES)
        }.commit()

        nav_view.setOnItemSelectedListener {menuItem ->
            when (menuItem.itemId) {
                R.id.quotes -> {
                    swapFragment(quotesFragment)
                    true
                }
                R.id.favorites -> {
                    swapFragment(favoritesFragment)
                    true
                }

                R.id.settings -> {
                    swapFragment(settingsFragments)
                    true
                }
                else -> true
            }
        }
    }

    private fun swapFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .hide(activeFragment)
            .show(fragment)
            .commit()
        activeFragment = fragment
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { fragment ->
            if (fragment != null && fragment.isVisible) {
                with(fragment.childFragmentManager) {
                    if (backStackEntryCount > 0) {
                        popBackStack()
                        return
                    }
                }
            }
        }
        super.onBackPressed()
    }
}
