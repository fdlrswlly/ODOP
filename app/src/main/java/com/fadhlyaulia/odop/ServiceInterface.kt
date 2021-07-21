package com.fadhlyaulia.odop

import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface{
    @GET("Laporan")
    fun getData(): Call<List<LaporanData>>
    @POST("Laporan")
    fun postLaporan(@Body laporanData: LaporanData): Call<LaporanData>
    @FormUrlEncoded
    @HTTP(method="PUT", path="Laporan", hasBody = true)
    fun updateLaporan(
        @Field("id") id: Int,
        @Field("nama") nama: String,
        @Field("jenis_kholas") nomor: String,
        @Field("surah") alamat: String): Call<LaporanData>
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Laporan", hasBody = true)
    fun deleteLaporan(@Field("id") id: Int): Call<LaporanData>

}