package com.fadhlyaulia.odop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var BtnDoa : androidx.cardview.widget.CardView
    lateinit var BtnLaporan : androidx.cardview.widget.CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BtnDoa = findViewById(R.id.btn_doa)
        BtnLaporan = findViewById(R.id.btn_laporan)
        BtnDoa.setOnClickListener{
            val pindah = Intent(this, DoaActivity::class.java)
            startActivity(pindah)
        }
        BtnLaporan.setOnClickListener{
            val pindah = Intent(this, LaporanActivity::class.java)
            startActivity(pindah)
        }

    }
}