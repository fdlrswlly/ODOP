package com.fadhlyaulia.odop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {
    lateinit var btnSubmit: Button
    lateinit var btnCancel: Button
    lateinit var etName: EditText
    lateinit var etId: EditText
    lateinit var etKholas: EditText
    lateinit var etSurah: EditText
    lateinit var apiService: ServiceInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        declaration()
        myfunction()
    }

    fun declaration() {
        btnSubmit = findViewById(R.id.btn_add_submit)
        btnCancel = findViewById(R.id.btn_add_cancel)
        etId = findViewById(R.id.et_add_id)
        etName = findViewById(R.id.et_add_name)
        etKholas = findViewById(R.id.et_add_kholas)
        etSurah = findViewById(R.id.et_add_surah)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
    }

    fun myfunction() {
        val pindah = Intent(this, MainActivity::class.java)
        btnSubmit.setOnClickListener {
            val array = LaporanData()
            array.id = etId.text.toString().toInt()
            array.nama = etName.text.toString()
            array.jenis_kholas = etKholas.text.toString()
            array.surah = etSurah.text.toString()
            apiService.postLaporan(array).enqueue(object : Callback<LaporanData> {
                override fun onResponse(call: Call<LaporanData>, response: Response<LaporanData>) {
                    startActivity(Intent(this@AddActivity, LaporanActivity::class.java))
                    Toast.makeText(baseContext, "Alhamdulillah! Laporanmu berhasil", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<LaporanData>, t: Throwable) {
                    Toast.makeText(baseContext, "Afwan! Laporanmu gagal", Toast.LENGTH_SHORT).show()
                }
            })
        }
        btnCancel.setOnClickListener {
            startActivity(pindah)
        }
    }
}