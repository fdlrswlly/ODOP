package com.fadhlyaulia.odop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Response


class LaporanActivity : AppCompatActivity() {
    lateinit var rvdata: RecyclerView
    lateinit var apiService: ServiceInterface
    private var  ambilData: ArrayList<LaporanData> = arrayListOf()
    lateinit var btnadd: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)
        rvdata = findViewById(R.id.rv_data)
        btnadd = findViewById(R.id.btn_main_add)
        btnadd.setOnClickListener {
            val pindah = Intent(this, AddActivity::class.java)
            startActivity(pindah)
        }

        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
        apiService.getData().enqueue(object : Callback<List<LaporanData>> {
            override fun onResponse(
                call: retrofit2.Call<List<LaporanData>>,
                response: Response<List<LaporanData>>
            ) {
                if (response.isSuccessful){
                    val res = response.body()
                    ambilData.addAll(res!!)
                    rvdata.layoutManager = LinearLayoutManager(this@LaporanActivity)
                    rvdata.adapter = LaporanAdapter(ambilData)
                }
            }
            override fun onFailure(call: retrofit2.Call<List<LaporanData>>, t: Throwable) {
            }
        })

    }
}
