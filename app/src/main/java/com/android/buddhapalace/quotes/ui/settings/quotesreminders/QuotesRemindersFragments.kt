package com.android.buddhapalace.quotes.ui.settings.quotesreminders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.observe
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.databinding.QuotesRemindersFragmentBinding
import com.android.buddhapalace.quotes.ui.allglobal.extentions.makeGone
import com.android.buddhapalace.quotes.ui.allglobal.extentions.makeVisible
import com.android.buddhapalace.quotes.ui.allglobal.extentions.onClick
import com.android.buddhapalace.quotes.ui.allglobal.extentions.setAppearance
import com.android.core.extensions.NavigationExt.setNavigationResult
import com.android.data.database.model.settings.DayWeek
import kotlinx.android.synthetic.main.quotes_reminders_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class QuotesRemindersFragments : Fragment(R.layout.quotes_reminders_fragment) {

    private val viewModel: QuotesRemindersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: QuotesRemindersFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.quotes_reminders_fragment, container, false
        )

        initListener(binding)
        viewModel.initData()

        return binding.root
    }

    private fun initListener(binding: QuotesRemindersFragmentBinding) {
        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }
        binding.quotesRemindersHandlers = viewModel
    }

    private fun render(state: QuotesRemindersState) {
        when (state) {
            QuotesRemindersState.Suspense -> {
            }

            QuotesRemindersState.Loading -> {
            }

            QuotesRemindersState.Back -> {
                setFragmentResult("someKey", bundleOf("bundle" to "button clicked 2"))
                (requireActivity() as MainActivity).onBackPressed()

            }

            is QuotesRemindersState.VisibleDescription -> {
                setVisibleDescription(state.state)
            }

            is QuotesRemindersState.AllDay -> {
                changeStateView(mon, false)
                changeStateView(tue, false)
                changeStateView(wen, false)
                changeStateView(thu, false)
                changeStateView(fri, false)
                changeStateView(sat, false)
                changeStateView(sun, false)
                changeStateView(every_day, true)
            }

            is QuotesRemindersState.StateDay -> {
                changeStateView(every_day, false)
                changeStateView(state.view!!, state.stateDay!!)
            }

            is QuotesRemindersState.StateDayFirst -> {
                state.settings.let {
                    setStateForDay(it.mapDayWeek)
                    setVisibleDescription(it.state)

                }
            }
        }
    }

    private fun setVisibleDescription(state: Boolean) {
        switch_description.isChecked = state
        if (state) description_view.makeVisible()
        else description_view.makeGone()
    }

    private fun changeStateView(textView: TextView, state: Boolean) {
        var backgroundColor =
            ContextCompat.getDrawable(requireActivity(), R.drawable.gradient_mango)
        val style = if (state) {
            R.style.week_day_active
        } else {
            backgroundColor = ContextCompat.getDrawable(requireActivity(), R.drawable.corner_gray)
            R.style.week_day
        }
        textView.setAppearance(requireActivity(), style)
        textView.background = backgroundColor
    }


    private fun setStateForDay(map: MutableMap<String, Boolean>) {
        changeStateView(mon, map[DayWeek.MONDAY.name]!!)
        changeStateView(tue, map[DayWeek.TUESDAY.name]!!)
        changeStateView(wen, map[DayWeek.WEDNESDAY.name]!!)
        changeStateView(thu, map[DayWeek.TUESDAY.name]!!)
        changeStateView(fri, map[DayWeek.FRIDAY.name]!!)
        changeStateView(sat, map[DayWeek.SATURDAY.name]!!)
        changeStateView(sun, map[DayWeek.SUNDAY.name]!!)
        changeStateView(every_day, map[DayWeek.ALL_DAY.name]!!)
    }
}
