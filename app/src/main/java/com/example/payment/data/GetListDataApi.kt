package com.example.pagos.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethods
import com.example.pagos.data.methodspaymentresponse.PaymentMethodsItem

interface GetListDataApi {

  @RequiresApi(Build.VERSION_CODES.N)
  fun listPaymentMethods(paymentList: List<PaymentMethodsItem>)
  @RequiresApi(Build.VERSION_CODES.N)
  fun listCardIssues(cardIssuersItem: List<CardIssuersItem>)

}