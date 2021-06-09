package com.android.buddapalace.ui.favorites

import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.android.buddapalace.MainActivity
import com.android.buddapalace.R

class FavoritesFragment  : Fragment(R.layout.favorites_fragment) {


    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).setStateBackGround(true)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            (requireActivity() as MainActivity).onBackPressedLast()
        }
    }
}