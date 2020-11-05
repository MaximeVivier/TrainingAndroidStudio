package fr.centraleMarseille.mvivier

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main3.*

class ShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val data: Uri? = intent?.data

        if (intent?.type?.startsWith("image/") == true) {
            // handle intents with image data
        } else if (intent?.type == "text/plain") {
            Log.d("TAG", intent?.getStringExtra(Intent.EXTRA_TEXT).toString())
        }
    }
}