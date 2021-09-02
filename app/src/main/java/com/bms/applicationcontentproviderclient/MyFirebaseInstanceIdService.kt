package com.bms.applicationcontentproviderclient


import android.util.Log
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.iid.FirebaseInstanceIdReceiver
import com.google.firebase.messaging.FirebaseMessaging


class FirebaseMessaging {

    override fun onTokenRefresh() {
        Log.i("**newTokenService", FirebaseMessaging.getInstance().token.toString())
    }

}
