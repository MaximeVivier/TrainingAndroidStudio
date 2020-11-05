package fr.centraleMarseille.mvivier

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "fr.centraleMarseille.mvivier.action.FOO"
private const val ACTION_BAZ = "fr.centraleMarseille.mvivier.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "fr.centraleMarseille.mvivier.extra.PARAM1"
private const val EXTRA_PARAM2 = "fr.centraleMarseille.mvivier.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class BackgroundService : IntentService("BackgroundService") {

    override fun onHandleIntent(intent: Intent?) {
        try {
            val dataString = intent!!.dataString
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("BackgroundService", "onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("BackgroundService", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("BackgroundService", "onCreate background")
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        TODO("Handle action Foo")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        TODO("Handle action Baz")
    }
}
