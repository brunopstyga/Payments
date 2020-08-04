package com.example.pagos.data

import com.example.pagos.data.installmentsresponse.InstallmentItem
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethodsItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET(value = "/v1/payment_methods")
     suspend fun getCurrentPaymentMethods
                (@Query("public_key") publicKey : String):
            Response <List<PaymentMethodsItem>>

    @GET(value = "/v1/payment_methods/card_issuers")
    suspend fun getCurrentCardIssuers(
        @Query("public_key") publicKey : String ,
        @Query("payment_method_id") paymentMethodId : String):
            Response <List<CardIssuersItem>>

    @GET(value = "/v1/payment_methods/installments")
    suspend fun getCurrentInstallments(
        @Query("public_key") publicKey : String ,
        @Query("bin") bin : Int ,
        @Query("amount") amount : String ,
        @Query("issuer.id") issuerid : Int):
            Response <List<InstallmentItem>>
}