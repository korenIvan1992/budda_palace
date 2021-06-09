package com.android.buddhapalace.quotes.ui.quotes

import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class QuotesFragment : Fragment(R.layout.quotes_fragment) {

    private val viewModel: QuotesViewModel by viewModel()

//    private val args: QuotesFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            (requireActivity() as MainActivity).onBackPressedLast()
        }
    }

    private fun render(state: QuotesState) {
        when (state) {
            QuotesState.Suspense -> {
            }
            QuotesState.Loading -> {
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setStateBackGround(true)
    }
}