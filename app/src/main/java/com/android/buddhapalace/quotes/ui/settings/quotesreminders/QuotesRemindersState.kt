package com.android.buddhapalace.quotes.ui.settings.quotesreminders

import android.view.View
import android.widget.TextView
import com.android.data.database.entity.settings.SettingsNotification
import com.android.data.database.model.settings.DayWeek


sealed class QuotesRemindersState {
    object Suspense : QuotesRemindersState()
    object Loading : QuotesRemindersState()
    object Back : QuotesRemindersState()
    data class StateDay(
        val map: MutableMap<String,Boolean>,
        val stateDay: Boolean?,
        val view : TextView?) : QuotesRemindersState()

    object AllDay : QuotesRemindersState()
    data class VisibleDescription(val state: Boolean) : QuotesRemindersState()
    data class StateDayFirst(val settings: SettingsNotification) : QuotesRemindersState()

}