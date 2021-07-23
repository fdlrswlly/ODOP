package com.fadhlyaulia.odop

object DoaData {
    private val namaDoa = arrayListOf(
        "Doa Sebelum Tidur",
        "Doa Bangun Tidur",
        "Doa Masuk Kamar Mandi",
        "Doa Keluar Rumah",
        "Doa Masuk Rumah"
    )
    private val Doa = arrayListOf(
        "بِسْمِكَ االلّٰهُمَّ اَحْيَا وَبِاسْمِكَ اَمُوْتُ",
        "اَلْحَمْدُ ِللهِ الَّذِىْ اَحْيَانَا بَعْدَمَآ اَمَاتَنَا وَاِلَيْهِ النُّشُوْرُ",
        "اَللّٰهُمَّ اِنّىْ اَعُوْذُبِكَ مِنَ الْخُبُثِ وَالْخَبَآئِثِ",
        "بِسْمِ اللهِ تَوَكَّلْتُ عَلَى اللهِ لاَحَوْلَ وَلاَقُوَّةَ اِلاَّ بِالل",
        "للّٰهُمَّ اِنّىْ اَسْأَلُكَ خَيْرَالْمَوْلِجِ وَخَيْرَالْمَخْرَجِ بِسْمِ اللهِ وَلَجْنَا وَبِسْمِ اللهِ خَرَجْنَا وَعَلَى اللهِ رَبّنَا تَوَكَّلْنَا"
    )
    private val Arti = arrayListOf(
        "Artinya: Dengan menyebut nama Allah, aku hidup dan aku mati",
        "Artinya: Segala puji bagi Allah yang telah menghidupkan kami sesudah kami mati (membangunkan dari tidur) dan hanya kepada-Nya kami dikembalikan",
        "Artinya: Ya Allah, aku berlindung pada-Mu dari godaan setan laki-laki dan setan perempuan",
        "Artinya: Dengan menyebut nama Allah aku bertawakal kepada Allah, tiada daya kekuatan melainkan dengan pertolongan Allah.",
        "Artinya: Ya Allah, sesungguhnya aku mohon kepada-Mu baiknya tempat masuk dan baiknya tempat keluar dengan menyebut nama Allah kami masuk, dan dengan menyebut nama Allah kami keluar dan kepada Allah Tuhan kami, kami bertawakkal."
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