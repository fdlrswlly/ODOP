package com.fadhlyaulia.odop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LoadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        Handler().postDelayed({
            val intent = Intent(this, MukadimahActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}