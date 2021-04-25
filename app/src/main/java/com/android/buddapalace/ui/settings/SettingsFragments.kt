package com.android.buddapalace.ui.settings

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.buddapalace.R
import com.android.buddapalace.data.Setting
import com.android.buddapalace.databinding.SettingsFragmentBinding
import com.android.buddapalace.databinding.SettingsItemBinding


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
            Setting(
                "Ура первый binding",
                requireActivity().getDrawable(R.drawable.calendar)!!
            )

        binding.two =
            Setting(
                "Ура второй binding",
                requireActivity().getDrawable(R.drawable.message)!!
            )

        return binding.root
    }

}