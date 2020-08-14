package com.example.pagos.business.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import com.bumptech.glide.Glide
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

    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, profileImage: String) {
            Glide.with(view.context)
                .load(profileImage)
                .override(200, 150)
                .into(view)
        }
}

    fun getCardIssuetsMethood() : MutableLiveData<List<PaymentMethodsItem>> = geoRepository.fetchListCardIssuers()

    fun getMethodCardIssuers() : MutableLiveData<List<CardIssuersItem>> = geoRepository.fetchListCurrentCardIssuers()

    fun getMethodInstallment() : MutableLiveData<List<InstallmentItem>> = geoRepository.fetchListCurrentInstallments()


}