package com.fadhlyaulia.odop
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
class DoaAdapter (private val listDoa: ArrayList<Doa>):RecyclerView.Adapter<DoaAdapter.DoaViewHolder>() {
    inner class DoaViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        var tvnamaDoa: TextView = itemView.findViewById(R.id.txt_nama_doa)
        var tvDoa: TextView = itemView.findViewById(R.id.txt_doa)
        var tvArti: TextView = itemView.findViewById(R.id.txt_arti_doa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.doa_item,parent,false)
        return DoaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoaViewHolder, position: Int) {
        val Doa = listDoa[position]
        holder.tvnamaDoa.text = Doa.nama_doa
        holder.tvDoa.text = Doa.doa
        holder.tvArti.text = Doa.arti
    }

    override fun getItemCount(): Int {
        return listDoa.size

    }
}