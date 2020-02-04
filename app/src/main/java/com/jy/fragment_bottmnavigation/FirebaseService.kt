package com.jy.fragment_bottmnavigation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class FirebaseService: FirebaseMessagingService() {

    private val TAG = this::class.java.simpleName
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.notification != null) {
            Log.i(TAG, "title " + remoteMessage.notification!!.title)
            Log.i(TAG, "body " + remoteMessage.notification!!.body)
            sendNotification(remoteMessage.notification?.title?:"", remoteMessage.notification?.body?:"")
        }
    }

    override fun onNewToken(s: String) {
        super.onNewToken(s)
        Log.i(TAG, "token $s")
    }

    private val channelRequestCode = 0
    private fun sendNotification(title: String, msg: String){
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, channelRequestCode, intent, PendingIntent.FLAG_ONE_SHOT)

        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val contentView = RemoteViews(packageName, R.layout.view_custom_notification)
        contentView.setTextViewText(R.id.title, title)
        contentView.setTextViewText(R.id.content, msg)
        contentView.setImageViewResource(R.id.image, R.drawable.common_full_open_on_phone)
        contentView.setImageViewResource(R.id.image_bg, R.drawable.bg_pure_color)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setCustomBigContentView(contentView)
            .setSmallIcon(R.drawable.ic_home_black_24dp)
//            .setContentTitle(title)
//            .setContentText(msg)
//            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())



        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(channelRequestCode /* ID of notification */, notificationBuilder.build())
    }

}