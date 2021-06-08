package com.android.buddapalace.ui.quotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.android.buddapalace.MainActivity
import com.android.buddapalace.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class QuotesFragment : Fragment(R.layout.quotes_fragment) {

    private val viewModel: QuotesViewModel by viewModel()

//    private val args: QuotesFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }

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