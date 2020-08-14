package com.example.pagos.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pagos.data.ApiService
import com.example.pagos.data.GetListDataApi
import com.example.pagos.data.installmentsresponse.InstallmentItem
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethods
import com.example.pagos.data.methodspaymentresponse.PaymentMethodsItem
import com.example.pagos.presentation.Util
import com.example.payment.presentation.MySharePreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject



class Repository @Inject constructor(private val apiService: ApiService?) :
    GetListDataApi {

    @Inject
    lateinit var mySharePreferences: MySharePreferences
    val listName : MutableList<String> = ArrayList()
    val listCard : MutableList<String> = ArrayList()

companion object {
    val listPayment : MutableList<PaymentMethods> = ArrayList()
    val listCardIssues : MutableList<CardIssuersItem> = ArrayList()
}

    var dataPaymentMethods: MutableLiveData<List<PaymentMethodsItem>> =
        MutableLiveData<List<PaymentMethodsItem>>()

    var dataCardIssuersItem: MutableLiveData<List<CardIssuersItem>> =
        MutableLiveData<List<CardIssuersItem>>()

    var dataInstallmentItem: MutableLiveData<List<InstallmentItem>> =
        MutableLiveData<List<InstallmentItem>>()

  fun fetchListCardIssuers() : MutableLiveData<List<PaymentMethodsItem>>{
      GlobalScope.launch(Dispatchers.IO){
          val response =  apiService !!.getCurrentPaymentMethods(Util.API_KEY)
          if (response.isSuccessful){
              response.body()?.let { listPaymentMethods(it) }
              dataPaymentMethods.postValue(response.body())
//              for (patmentmetho in response.body()!!){
//                  listName.add(patmentmetho.name);
//              }
          }else{
              Log.d("TGI", "ERROR:" + response.message())
          }
      }

      return dataPaymentMethods;
    }

    fun fetchListCurrentCardIssuers() : MutableLiveData<List<CardIssuersItem>>{
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService !!.getCurrentCardIssuers(Util.API_KEY, Util.PAYMENT_METHOD_ID)
            if (response.isSuccessful){
                response.body()?.let { listCardIssues(it) }
                dataCardIssuersItem.postValue(response.body())
            }
        }
        return dataCardIssuersItem
    }

    fun fetchListCurrentInstallments() : MutableLiveData<List<InstallmentItem>>{
    GlobalScope.launch(Dispatchers.IO) {
        val response = apiService !!.getCurrentInstallments(
            Util.API_KEY ,
            Util.BIN ,
            Integer.toString(mySharePreferences.getAmount("-1")),
            mySharePreferences.getData(""))
        if (response.isSuccessful){
//            response.body()?.let { listCardIssues(it) }
            dataInstallmentItem.postValue(response.body())
        }
    }
    return dataInstallmentItem
}

    override fun listPaymentMethods(paymentList: List<PaymentMethodsItem>) {
        paymentList.forEach {
            listPayment.add(PaymentMethods(it.id.toString(),it.name.toString(),
                it.paymentTypeId.toString(),it.status.toString(), it.thumbnail.toString()))
        }
        listPayment.forEach {
            listName.add(it.name.toString())
        }
    }


    override fun listCardIssues(cardIssuersItem: List<CardIssuersItem>) {
        cardIssuersItem.forEach {
            listCardIssues.add(CardIssuersItem(it.id.toString(),it.name.toString(),
                it.secureThumbnail.toString(),it.secureThumbnail.toString(),"",""))
        }
        cardIssuersItem.forEach {
            listCard.add(it.name.toString())
        }
    }


}
