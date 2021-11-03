package com.android.data.datasource.remoute

import android.content.Context
import android.widget.Toast
import com.android.data.network.model.QuotesDto
import com.android.data.network.model.Result
import com.android.data.network.service.BaseApiService
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.gson.Gson
import timber.log.Timber
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class QuotesRemoteDataSource(val context: Context, val api: BaseApiService) {

    suspend fun getQuotes(): Result<List<QuotesDto>> {

        return suspendCoroutine { suspendResult->
             try {

                val remoteConfig = Firebase.remoteConfig
                val configSettings = remoteConfigSettings {
                    minimumFetchIntervalInSeconds = 3600
                }
                remoteConfig.setConfigSettingsAsync(configSettings)

                val cacheExpiration: Long = 3600

                remoteConfig.fetch(cacheExpiration)
                    .addOnCompleteListener { task ->
                        run {
                            if (task.isSuccessful) {
                                remoteConfig.activate()
                                val data = remoteConfig.getString("quotes")
                                val listQuotes: List<QuotesDto> =
                                    Gson().fromJson(data, Array<QuotesDto>::class.java).toList()
                                suspendResult.resume(Result.Success(listQuotes))
                            }
                        }
                    }

            } catch (e: Throwable) {
                 suspendResult.resume( Result.Error(IOException("Error logging in", e)))
            }
        }
    }
}