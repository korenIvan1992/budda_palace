package com.android.buddhapalace.quotes.ui.settings

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.databinding.SettingsFragmentBinding
import com.android.buddhapalace.quotes.model.settings.Setting
import com.android.buddhapalace.quotes.ui.allglobal.extentions.openFragmentChild
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SettingsFragments : Fragment(R.layout.settings_fragment) {

    private val viewModel: SettingsViewModel by viewModel()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: SettingsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.settings_fragment, container, false
        )

        initBinding(binding)
        initListener(binding)

        return binding.root
    }

    private fun initListener(binding: SettingsFragmentBinding) {
        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }
        binding.settingsHandlers = viewModel
    }

    private fun initBinding(binding: SettingsFragmentBinding) {
        binding.dailyQuotesReminders = Setting(
            getString(R.string.daily_quotes_reminders),
            ContextCompat.getDrawable(requireActivity(), R.drawable.calendar)
        )
        binding.giveUsFeedback = Setting(
            getString(R.string.give_us_feedback),
            ContextCompat.getDrawable(requireActivity(), R.drawable.message)
        )
        binding.rateApp = Setting(
            getString(R.string.rate_the_app),
            ContextCompat.getDrawable(requireActivity(), R.drawable.star_outline_1)
        )
        binding.recommendApp = Setting(
            getString(R.string.recommend_app),
            ContextCompat.getDrawable(requireActivity(), R.drawable.share)
        )
        binding.acknowledgement = Setting(getString(R.string.acknowledgement), null)
        binding.aboutBuddhaPalace = Setting(getString(R.string.about_buddha_palace), null)
    }

    private fun render(state: SettingsState) {
        CoroutineScope(Dispatchers.Main).launch {
            when (state) {
                SettingsState.Suspense -> {
                    Timber.d("RENDER SettingsState.Suspense")
                }
                SettingsState.Loading -> {
                    Timber.d("RENDER SettingsState.Loading")
                }

                is SettingsState.OpenFragment -> openFragmentChild(
                    requireActivity(),
                    fr = state.fr
                )
            }
        }
    }
}
