package com.fadhlyaulia.odop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.provider.Telephony
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView

class DoaActivity : AppCompatActivity() {
    private lateinit var rvDoa: RecyclerView
    private var list: ArrayList<Doa> = arrayListOf()
    lateinit var btnex : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doa)
        btnex = findViewById(R.id.btn_doa_exit)
        rvDoa = findViewById(R.id.rv_doa)
        rvDoa.setHasFixedSize(true)

        list.addAll(DoaData.listData)
        showRecyclerViewListMode()

        btnex.setOnClickListener {
            val pindah = Intent(this, MainActivity::class.java)
            startActivity(pindah)
        }

    }

    private fun showRecyclerViewListMode() {
        rvDoa.layoutManager = LinearLayoutManager(this)
        val doaAdapter = DoaAdapter(list)
        rvDoa.adapter = doaAdapter
    }

}