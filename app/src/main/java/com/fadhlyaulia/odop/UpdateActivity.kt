package com.fadhlyaulia.odop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fadhlyaulia.odop.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity() {
    lateinit var btnSubmit: Button
    lateinit var btnCancel: Button
    lateinit var etName: EditText
    lateinit var etKholas: EditText
    lateinit var etsurah: EditText
    lateinit var valName: String
    lateinit var valKholas: String
    lateinit var valSurah: String
    lateinit var valId: String
    lateinit var apiService: ServiceInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        getMyData()
        declaration()
        myfunction()
    }

    fun declaration() {
        btnSubmit = findViewById(R.id.btn_up_submit)
        btnCancel = findViewById(R.id.btn_up_cancel)
        etName = findViewById(R.id.et_up_name)
        etKholas = findViewById(R.id.et_up_kholas)
        etsurah = findViewById(R.id.et_up_surah)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
    }

    fun getMyData() {
        val myValue = intent.extras
        if (myValue != null) {
            valName = myValue.getString("nama").toString()
            valKholas = myValue.getString("jenis_kholas").toString()
            valSurah = myValue.getString("surah").toString()
            valId = myValue.getString("id").toString()
        }
    }

    fun myfunction() {
        etName.setText(valName)
        etKholas.setText(valKholas)
        etsurah.setText(valSurah)
        val pindah = Intent(this, LaporanActivity::class.java)
        btnSubmit.setOnClickListener {
            apiService.updateLaporan(
                valId.toInt(),
                etName.text.toString(),
                etKholas.text.toString(),
                etsurah.text.toString()
            ).enqueue(object : Callback<LaporanData> {
                override fun onResponse(call: Call<LaporanData>, response: Response<LaporanData>) {
                    startActivity(pindah)
                    Toast.makeText(baseContext, "Update Data Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<LaporanData>, t: Throwable) {
                    Toast.makeText(baseContext, "Update Data Failed", Toast.LENGTH_SHORT).show()
                }

            })
        }
        btnCancel.setOnClickListener {
            startActivity(pindah)
        }
    }
}