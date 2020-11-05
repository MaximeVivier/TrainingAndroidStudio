package fr.centraleMarseille.mvivier

import android.app.Activity
import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    var mService: BoundService? = null
    var mBound = false

    val ForResultActi_3 = 100

    val br: BroadcastReceiver = MyBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Je suis dans onCreate")

        button_get_result.setOnClickListener {
            val monIntent = Intent(this, MainActivity3::class.java)
            startActivityForResult(monIntent, ForResultActi_3)
        }

        createButton.setOnClickListener {
            val myIntent = Intent(this, BackgroundService::class.java)
            startService(myIntent)
        }

        destroyButton.setOnClickListener {
            val myIntent = Intent(this, BackgroundService::class.java)
            stopService(myIntent)
        }

        three_buttons_acti.setOnClickListener {
            val myIntent = Intent(this, ThreeButtonsActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?) {
        if (requestCode == ForResultActi_3) {
            Log.d("onActivityResult", "first" + resultCode)
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this@MainActivity, "ret: " + data?.getStringExtra("ret"), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun finish() {
        super.finish()
        Log.d("MainActivity", "finish")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
        Log.d("MainActivity", "onDestroy")
    }

    override fun onStart() {
        super.onStart()
        // BIND LOCAL SERVICE
        val intent = Intent(this, BoundService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
        Log.d("MainActivity", "onStart")
    }

    fun onButtonClickBound(v: View?) {
        if (mBound) {
            val num: Int = mService!!.getRandomNumber()
            Toast.makeText(this, "number: $num", Toast.LENGTH_SHORT).show()
        }
    }

    private val connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder: BoundService.LocalBinder = service as BoundService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

}