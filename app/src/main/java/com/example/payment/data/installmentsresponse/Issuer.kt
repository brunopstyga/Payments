package com.example.pagos.data.installmentsresponse


import com.google.gson.annotations.SerializedName

data class Issuer(
    val id: String,
    val name: String,
    @SerializedName("secure_thumbnail")
    val secureThumbnail: String,
    val thumbnail: String
)