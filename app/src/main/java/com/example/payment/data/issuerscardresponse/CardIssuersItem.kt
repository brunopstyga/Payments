package com.example.pagos.data.issuerscardresponse


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardIssuersItem(
    val id: String,
    val name: String,
    @SerializedName("secure_thumbnail")
    val secureThumbnail: String,
    val thumbnail: String,
    @SerializedName("processing_mode")
    val processingMode: String,
    @SerializedName("merchant_account_id")
    val merchantAccountId: String
) : Parcelable

