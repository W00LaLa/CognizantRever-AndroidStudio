package com.example.cognizantrever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log

class SMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "Woolala, sms from cognizant.")

        val bundle = intent.extras
        if (bundle != null) {
            // Get the array of PDUs (Protocol Data Units) from the bundle
            val pdus = bundle["pdus"] as Array<*>?
            if (pdus != null) {
                // Initialize an array to hold the SmsMessage objects
                val messages: Array<SmsMessage?> = Array(pdus.size) { null }
                // Loop through each PDU and create an SmsMessage object from it
                for (i in pdus.indices) {
                    messages[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
                }
                // Check if the messages array is not empty and the first message is not null
                if (messages.isNotEmpty() && messages[0] != null) {
                    val messageBody = messages[0]?.messageBody
                    //Extract the content and the sender's phone number from the SMS
                    val phoneNumber = messages[0]?.displayOriginatingAddress

                    Log.i(TAG, "Message received: $messageBody")
                    Log.i(TAG, "Phone number is: $phoneNumber")
                }
            }
        }
    }

    companion object{
        var TAG = SMSReceiver::class.java.simpleName
    }
}
