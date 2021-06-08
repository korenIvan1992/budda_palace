package com.android.buddapalace.ui.settings

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.android.buddapalace.MainActivity
import com.android.buddapalace.R
import com.android.buddapalace.databinding.SettingsFragmentBinding
import com.android.buddapalace.model.settings.Setting
import org.koin.androidx.viewmodel.ext.android.viewModel


class SettingsFragments : Fragment(R.layout.settings_fragment) {

    private val viewModel: SettingsViewModel by viewModel()


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }


        val binding: SettingsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.settings_fragment, container, false
        )

        binding.settingsHandlers = SettingsHandlers()

        binding.dailyQuotesReminders =
            Setting(
                getString(R.string.daily_quotes_reminders),
                requireActivity().getDrawable(R.drawable.calendar)!!
            )

        binding.giveUsFeedback =
            Setting(
                getString(R.string.give_us_feedback),
                requireActivity().getDrawable(R.drawable.message)!!
            )

        binding.rateApp =
            Setting(
                getString(R.string.rate_the_app),
                requireActivity().getDrawable(R.drawable.star_outline_1)!!
            )

        binding.recommendApp =
            Setting(
                getString(R.string.recommend_app),
                requireActivity().getDrawable(R.drawable.share)!!
            )

        binding.acknowledgement =
            Setting(
                getString(R.string.acknowledgement),
                null
            )

        binding.aboutBuddhaPalace =
            Setting(
                getString(R.string.about_buddha_palace),
                null
            )

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setStateBackGround(false)
    }


    private fun render(state: SettingsState) {
        when (state) {
            SettingsState.Suspense -> {
            }
            SettingsState.Loading -> {
            }
        }
    }
}

class SettingsHandlers {
    fun clickRate(view: View) {
        view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.growmeup.android")))
    }
    fun clickDailyReminder(view: View) {
        (view.context as MainActivity).navController.navigate(R.id.quotes_reminder)
    }
}
