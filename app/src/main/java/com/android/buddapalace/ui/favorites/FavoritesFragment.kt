package com.android.buddapalace.ui.favorites

import androidx.fragment.app.Fragment
import com.android.buddapalace.MainActivity
import com.android.buddapalace.R

class FavoritesFragment  : Fragment(R.layout.favorites_fragment) {


    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setStateBackGround(true)
    }
}