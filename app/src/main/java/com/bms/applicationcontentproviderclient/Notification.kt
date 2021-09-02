package com.bms.applicationcontentproviderclient

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat

lateinit var notificationChannel: NotificationChannel
lateinit var notificationManager: NotificationManager
lateinit var builder: NotificationCompat.Builder

fun Context.showNotification(channelId: String, title: String, body: String){

    //gerencia todas as notificações do app
    notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent =  Intent(this, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

    //VERSÃO
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        //responsavel por manipular o objeto da notificação
        notificationChannel = NotificationChannel(channelId, body, NotificationManager.IMPORTANCE_HIGH) .apply { //high -  notificação importancia alta
            lightColor = Color.RED
            enableVibration(true)
        }
        notificationManager.createNotificationChannel(notificationChannel)
        //iniciar builder, responsavel pelo disparo 
        builder = NotificationCompat.Builder(this, channelId).apply {
            setSmallIcon(R.drawable.ic_baseline_add_24)
            setContentTitle(title)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }

    }
    notificationManager.notify(channelId.toInt(), builder.build())

}
