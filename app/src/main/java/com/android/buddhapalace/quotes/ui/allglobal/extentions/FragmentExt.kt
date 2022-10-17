package com.android.buddhapalace.quotes.ui.allglobal.extentions

import androidx.fragment.app.FragmentActivity
import com.android.buddhapalace.quotes.R


fun openFragmentChild(act: FragmentActivity, fr: androidx.fragment.app.Fragment) {
    act.supportFragmentManager
        .beginTransaction()
        .add(R.id.container_child_fragment, fr)
        .addToBackStack(null)
        .commit()
}





