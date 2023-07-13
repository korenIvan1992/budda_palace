package com.android.buddhapalace.quotes.ui.settings.quotesreminders

import android.view.View
import android.widget.TextView
import androidx.lifecycle.viewModelScope
import com.android.buddhapalace.quotes.ui.allglobal.BaseViewModel
import com.android.core.extensions.set
import com.android.core.extensions.toast
import com.android.data.PreferenceManager
import com.android.data.database.model.settings.DayWeek
import com.android.data.repository.settings.SettingsRepositories
import kotlinx.coroutines.*

class QuotesRemindersViewModel(
    val pref: PreferenceManager,
    private val settingsRepositories: SettingsRepositories
) : BaseViewModel<QuotesRemindersState>(QuotesRemindersState.Suspense) {

    private val settingsLocalDataSource = settingsRepositories.settingsLocalDataSource

    fun back() {
        state.set(QuotesRemindersState.Back)
    }

    fun clickWeekDay(day: Int, view: View) {
        val dayWeek = DayWeek.values()[day - 1]

        settingsLocalDataSource.settingsNotification?.let {
            var stateDay = it.mapDayWeek[dayWeek.name]
            if (day == 8) {
                if (stateDay == false) {
                    state.set(QuotesRemindersState.AllDay)
                    settingsLocalDataSource.allDay()
                }
            } else {
                state
                    .set(
                        QuotesRemindersState.StateDay(
                            it.mapDayWeek,
                            !stateDay!!,
                            view as TextView
                        )
                    )
                settingsLocalDataSource.changeSettingDay(dayWeek)
            }

        }
    }

    fun onCheckedChanged(checked: Boolean) {
        settingsLocalDataSource.changeAllowNotification(checked)
        state.set(QuotesRemindersState.VisibleDescription(checked))
    }

    fun initData() {
        viewModelScope.launch {
            settingsLocalDataSource.getSetting().let {
                withContext(Dispatchers.Main) {
                    state.set(QuotesRemindersState.StateDayFirst(it))
                }
            }
        }
    }
}

