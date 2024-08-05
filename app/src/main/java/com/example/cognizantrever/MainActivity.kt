package com.example.cognizantrever

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.ComponentName
import android.widget.Button
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.util.Log
import com.example.cognizantrever.networking.MarsApi

class MainActivity : AppCompatActivity() {
    lateinit var jsonButton: Button
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        jsonButton = findViewById(R.id.btnJson)
        jsonButton.setOnClickListener {
            getMarsPhotos()
        }
    }

    // Write in editText then print the content on textView
    fun clickHandler(view: View) {
        var nameEditText :  EditText = findViewById(R.id.etName)
        var mainTextView : TextView = findViewById(R.id.tvMain)

        var data = nameEditText.text.toString()
        mainTextView.setText(data)

        //takes the data info to an intent that opens another activity HomeActivity.java
        var hIntention = Intent(this, HomeActivity::class.java)
        //sends info with name mykey with the data in data
        hIntention.putExtra("mykey", data)
        //opens activity
        startActivity(hIntention)
    }

    fun openDialer(view: View) {
        //opens the dialer with the given phone number
        var dialerIntention = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"))
        startActivity(dialerIntention)
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        //  if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        // }
    }

    fun setAlarm(view: View) {
        createAlarm("Im coming for you!", 3,25 )
    }

    fun openMyCalendar(view: View) {
        var calIntent = Intent("cognizant.portugal.android")  //calling calendar
        //var calIntent = Intent("ineed.water")
        startActivity(calIntent)
    }

    fun sendFlightBroadcast(view: View){
        var flightIntent = Intent("ihave.flight")
        //sendBroadcast(flightIntent)
        intent.setComponent(
            ComponentName(
                "com.example.secondcognizant",
                "com.example.secondcognizant.FlightReceiver"
            )
        )

        sendBroadcast(flightIntent,"mypermission.password.portugal")
    }

    private fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.IO) {       //async await
            val listMarsPhoto = MarsApi.retrofitService.getPhotos()
            Log.i(TAG,listMarsPhoto.get(0).imgSrc)
        }
    }
}