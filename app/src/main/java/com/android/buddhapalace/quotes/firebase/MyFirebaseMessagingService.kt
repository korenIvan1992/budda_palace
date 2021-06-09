package com.android.buddhapalace.quotes.firebase


import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Timber.d("$remoteMessage")
        remoteMessage.notification?.let {
            val title: String = if (it.title != null) it.title.toString() else "без title"
            val body: String = if (it.body != null) it.body.toString() else "без body"
            NotificationService.sendNotification(title, body)
        }
    }

    override fun onNewToken(s: String) {
        super.onNewToken(s)
    }

    companion object {
        private val TAG = "FirebaseMessageService"
    }

}

