package com.example.pagos.data.installmentsresponse


import com.google.gson.annotations.SerializedName

data class InstallmentItem(
    @SerializedName("payment_method_id")
    val paymentMethodId: String,
    @SerializedName("payment_type_id")
    val paymentTypeId: String,
    val issuer: Issuer,
    @SerializedName("processing_mode")
    val processingMode: String,
    @SerializedName("merchant_account_id")
    val merchantAccountId: Any,
    @SerializedName("payer_costs")
    val payerCosts: List<PayerCost>,
    val agreements: Any
)