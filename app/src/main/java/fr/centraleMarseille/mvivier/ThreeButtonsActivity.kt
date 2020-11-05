package fr.centraleMarseille.mvivier

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_three_buttons.*

class ThreeButtonsActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_buttons)

        val simpleButton = simpleButton
        simpleButton.setOnClickListener { v: View? ->
            Log.d("ThreeButtonActivity", "Simple button trigger")
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

        classButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("ThreeButtonActivity", "Class button trigger")
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }

    fun xmlButtonTrigger(view: View) {
        Log.d("ThreeButtonActivity", "XML button trigger")
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }
}