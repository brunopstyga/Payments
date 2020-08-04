package com.example.pagos.data.methodspaymentresponse


import com.google.gson.annotations.SerializedName

data class PaymentMethodsItem(
    val id: String,
    val name: String,
    @SerializedName("payment_type_id")
    val paymentTypeId: String,
    val status: String,
    @SerializedName("secure_thumbnail")
    val secureThumbnail: String,
    val thumbnail: String,
    @SerializedName("deferred_capture")
    val deferredCapture: String,
    val settings: List<Any>,
    @SerializedName("additional_info_needed")
    val additionalInfoNeeded: List<Any>,
    @SerializedName("min_allowed_amount")
    val minAllowedAmount: Double,
    @SerializedName("max_allowed_amount")
    val maxAllowedAmount: Int,
    @SerializedName("accreditation_time")
    val accreditationTime: Int,
    @SerializedName("financial_institutions")
    val financialInstitutions: List<Any>,
    @SerializedName("processing_modes")
    val processingModes: List<String>
)