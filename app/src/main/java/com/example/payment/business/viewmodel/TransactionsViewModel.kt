package com.example.pagos.business.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.pagos.data.installmentsresponse.InstallmentItem
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethodsItem
import com.example.pagos.repository.Repository
import javax.inject.Inject


class TransactionsViewModel @Inject constructor(
    application: Application,
    public val geoRepository: Repository

   )
    : AndroidViewModel(application){

    private val _navigatePaymentDetail = MutableLiveData<String>()
    val navigatePaymentDetail
        get() = _navigatePaymentDetail

    fun pymentMethoClicked(id: String) {
        _navigatePaymentDetail.value = id
    }


    fun onPaymentClicked(id: String) {
        _navigatePaymentDetail?.value = id
    }

    fun getMethodPaymetList() : MutableLiveData<List<PaymentMethodsItem>> = geoRepository.fetchListPaymentMethods()

    fun getMethodCardIssuers() : MutableLiveData<List<CardIssuersItem>> = geoRepository.fetchListCurrentCardIssuers()

//    fun getMethodInstallment() : MutableLiveData<List<InstallmentItem>> = geoRepository.fetchListCurrentInstallments()


}