package fr.centraleMarseille.mvivier

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main3.*

private const val TAG = "Activity3"

class MainActivity3 : AppCompatActivity() {

    val br: BroadcastReceiver = MyBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        Log.d(TAG, "acti 3 launched")

        validateButton.setOnClickListener {
            val myIntent = Intent().apply {
                putExtra("ret", TextInput.text.toString())
            }
            setResult(Activity.RESULT_OK, myIntent)
            finish()
        }

        broadcastButton.setOnClickListener {
            Intent().also {intent ->
                intent.setAction("com.example.myapplication.MY_NOTIFICATION")
                sendBroadcast(intent)
            }
        }

        appChooserButton.setOnClickListener {
            val title: String = resources.getString(R.string.chooser_title)

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "this is my text to send")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, title)
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(shareIntent)
            }
        }

        val filter = IntentFilter("com.example.myapplication.MY_NOTIFICATION")
        registerReceiver(br, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "On destroy called")
        unregisterReceiver(br)
    }
}