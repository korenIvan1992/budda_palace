package com.android.buddhapalace.quotes.firebase

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R

@SuppressLint("StaticFieldLeak")
object NotificationService {

    private lateinit var context : Context

    fun instance(context: Context){
        this.context = context
    }
    fun sendNotification(titleText: String, message: String) {

        val CHANNEL_ID = "my_channel_01"// The id of the channel.
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // В Android O это необходимо использовать NotificationChannel и NotificationCompat.Builder является устаревшим
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, "1", importance)
            mChannel.setShowBadge(true)
            mChannel.audioAttributes
            mChannel.enableLights(true)
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            notificationManager.createNotificationChannel(mChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.icon)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    context.resources,
                    R.mipmap.icon
                )
            )
            .setContentTitle(titleText)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(message)
            )
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setGroupSummary(true)
            .setChannelId(CHANNEL_ID)

        notificationManager.notify(1, notificationBuilder.build())
    }
}