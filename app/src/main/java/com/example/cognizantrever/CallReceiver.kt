package com.example.cognizantrever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log


class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != null && intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
            val callState = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

            if (callState != null) {
                when (callState) {
                    TelephonyManager.EXTRA_STATE_RINGING -> {
                        Log.i("CallLog", "Incoming call from:  $phoneNumber")
                    }
                    TelephonyManager.EXTRA_STATE_OFFHOOK -> {
                        Log.i("CallLog", "Outgoing call to: $phoneNumber")
                    }
                    TelephonyManager.EXTRA_STATE_IDLE -> {
                        Log.i("CallLog", "Call ended.")
                    }
                }
            }
        }
    }
}