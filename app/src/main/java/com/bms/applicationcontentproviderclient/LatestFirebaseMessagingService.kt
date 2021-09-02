package com.bms.applicationcontentproviderclient

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class LatestFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(mToken: String) {
        super.onNewToken(mToken)
        Log.e("TOKEN", mToken)
    }



    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
    }


}