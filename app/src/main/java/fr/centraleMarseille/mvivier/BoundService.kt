package fr.centraleMarseille.mvivier

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class BoundService : Service() {

    private val binder: IBinder = LocalBinder()

    private val mGenerator = Random()

    inner class LocalBinder : Binder() {
        fun getService(): BoundService {
            return this@BoundService
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun getRandomNumber(): Int {
        return mGenerator.nextInt(100)
    }
}
