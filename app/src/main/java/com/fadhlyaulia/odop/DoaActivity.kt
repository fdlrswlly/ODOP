package com.fadhlyaulia.odop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.provider.Telephony
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView

class DoaActivity : AppCompatActivity() {
    private lateinit var rvDoa: RecyclerView
    private var list: ArrayList<Doa> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doa)

        rvDoa = findViewById(R.id.rv_doa)
        rvDoa.setHasFixedSize(true)

        list.addAll(DoaData.listData)
        showRecyclerViewListMode()

    }

    private fun showRecyclerViewListMode() {
        rvDoa.layoutManager = LinearLayoutManager(this)
        val doaAdapter = DoaAdapter(list)
        rvDoa.adapter = doaAdapter
    }
}