package com.android.buddapalace.ui.settings

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.buddapalace.R
import com.android.data.domain.Setting
import com.android.buddapalace.databinding.SettingsFragmentBinding


class SettingsFragments : Fragment(R.layout.settings_fragment) {


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SettingsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.settings_fragment, container, false
        )

        binding.one =
            Setting("Daily quotes reminders",
                requireActivity().getDrawable(R.drawable.calendar)!!
            )

        binding.two =
            Setting("Give us feedback",
                requireActivity().getDrawable(R.drawable.message)!!
            )

        binding.three =
            Setting("Rate the app",
                requireActivity().getDrawable(R.drawable.star_outline_1)!!
            )
        binding.four =
            Setting("Recommend app",
                requireActivity().getDrawable(R.drawable.share)!!
            )

        return binding.root
    }

}