package com.fadhlyaulia.odop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaporanAdapter(private val listku: ArrayList<LaporanData>): RecyclerView.Adapter<LaporanAdapter.LaporanViewHolder>() {

    inner class LaporanViewHolder(viewku: View) : RecyclerView.ViewHolder(viewku) {
        var tvId: TextView = viewku.findViewById(R.id.tv_id)
        var tvNama: TextView = viewku.findViewById(R.id.tv_nama)
        var tvJenisKholas: TextView = viewku.findViewById(R.id.tv_jenis_kholas)
        var tvSurah: TextView = viewku.findViewById(R.id.tv_surah)
        var btnDelete: ImageButton = viewku.findViewById(R.id.btn_data_del)
        var btnUpdate: ImageButton = viewku.findViewById(R.id.btn_data_edit)
        var apiIterface: ServiceInterface? =
            Repository.getDataAPI().create(ServiceInterface::class.java)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaporanViewHolder {
        val viewView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return LaporanViewHolder(viewView)
    }

    override fun onBindViewHolder(holder: LaporanViewHolder, position: Int) {
        val dataku = listku[position]
        holder.tvId.text = dataku.id.toString()
        holder.tvNama.text = dataku.nama
        holder.tvJenisKholas.text = dataku.jenis_kholas
        holder.tvSurah.text = dataku.surah
        holder.btnUpdate.setOnClickListener {
            val bundle = Bundle()
            val pindah = Intent(holder.itemView.context, UpdateActivity::class.java)
            bundle.putString("id", dataku.id.toString())
            bundle.putString("nama", dataku.nama.toString())
            bundle.putString("jenis_kholas", dataku.jenis_kholas.toString())
            bundle.putString("surah", dataku.surah.toString())
            pindah.putExtras(bundle)
            holder.itemView.context.startActivity(pindah)
        }
        holder.btnDelete.setOnClickListener {
            holder.apiIterface!!.deleteLaporan(dataku.id!!).enqueue(object : Callback<LaporanData> {
                override fun onResponse(call: Call<LaporanData>, response: Response<LaporanData>) {
                    if (response.isSuccessful) {
                        listku.removeAt(position)
                        notifyDataSetChanged()
                        Toast.makeText(
                            holder.itemView.context,
                            "Delete Data Berhasil",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LaporanData>, t: Throwable) {
                    Toast.makeText(
                        holder.itemView.context,
                        "Delete Data Gagal",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
        }
    }

    override fun getItemCount(): Int {
        return listku.size
    }

}
