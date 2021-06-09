package com.android.buddhapalace.quotes.ui.favorites

import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R

class FavoritesFragment  : Fragment(R.layout.favorites_fragment) {


    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).setStateBackGround(true)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            (requireActivity() as MainActivity).onBackPressedLast()
        }
    }
}