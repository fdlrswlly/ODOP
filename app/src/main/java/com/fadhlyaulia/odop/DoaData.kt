package com.fadhlyaulia.odop

object DoaData {
    private val namaDoa = arrayListOf(
        "Doa Sebelum Tidur",
        "Doa Bangun Tidur",
        "Doa Masuk Kamar Mandi"
    )
    private val Doa = arrayListOf(
        "بِسْمِكَ االلّٰهُمَّ اَحْيَا وَبِاسْمِكَ اَمُوْتُ",
        "اَلْحَمْدُ ِللهِ الَّذِىْ اَحْيَانَا بَعْدَمَآ اَمَاتَنَا وَاِلَيْهِ النُّشُوْرُ",
        "اَللّٰهُمَّ اِنّىْ اَعُوْذُبِكَ مِنَ الْخُبُثِ وَالْخَبَآئِثِ"
    )
    private val Arti = arrayListOf(
        "Artinya: Dengan menyebut nama Allah, aku hidup dan aku mati",
        "Artinya: Segala puji bagi Allah yang telah menghidupkan kami sesudah kami mati (membangunkan dari tidur) dan hanya kepada-Nya kami dikembalikan",
        "Artinya: Ya Allah, aku berlindung pada-Mu dari godaan setan laki-laki dan setan perempuan"
    )
    val listData:ArrayList<Doa>
    get(){
        val listDoa = arrayListOf<Doa>()
        for (position in namaDoa.indices){
            val doa = Doa()
            doa.nama_doa = namaDoa[position]
            doa.doa = Doa[position]
            doa.arti = Arti[position]
            listDoa.add(doa)
        }
        return listDoa
    }
}