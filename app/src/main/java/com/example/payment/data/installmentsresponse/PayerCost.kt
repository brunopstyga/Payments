package com.example.pagos.data.installmentsresponse


import com.google.gson.annotations.SerializedName

data class PayerCost(
    val installments: Int,
    @SerializedName("installment_rate")
    val installmentRate: Int,
    @SerializedName("discount_rate")
    val discountRate: Int,
    @SerializedName("reimbursement_rate")
    val reimbursementRate: Any,
    val labels: List<String>,
    @SerializedName("installment_rate_collector")
    val installmentRateCollector: List<String>,
    @SerializedName("min_allowed_amount")
    val minAllowedAmount: Int,
    @SerializedName("max_allowed_amount")
    val maxAllowedAmount: Int,
    @SerializedName("recommended_message")
    val recommendedMessage: String,
    @SerializedName("installment_amount")
    val installmentAmount: Int,
    @SerializedName("total_amount")
    val totalAmount: Int,
    @SerializedName("payment_method_option_id")
    val paymentMethodOptionId: String
)