package com.android.buddapalace.ui.settings.quotesreminders

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.android.buddapalace.MainActivity
import com.android.buddapalace.R
import com.android.buddapalace.databinding.QuotesRemindersFragmentBinding
import com.android.buddapalace.ui.allglobal.extentions.makeGone
import com.android.buddapalace.ui.allglobal.extentions.makeVisible
import org.koin.androidx.viewmodel.ext.android.viewModel


class QuotesRemindersFragments : Fragment(R.layout.quotes_reminders_fragment) {

    private val viewModel: QuotesRemindersViewModel by viewModel()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }

        val binding: QuotesRemindersFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.quotes_reminders_fragment, container, false
        )

        binding.quotesRemindersHandlers = viewModel

        return binding.root
    }


    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).bottomNavigationView.makeGone()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as MainActivity).bottomNavigationView.makeVisible()
    }


    private fun render(state: QuotesReminersState) {
        when (state) {
            QuotesReminersState.Suspense -> {
            }
            QuotesReminersState.Loading -> {
            }
            QuotesReminersState.Back -> {
                (requireActivity() as MainActivity).navController.popBackStack()
            }
        }
    }
}
