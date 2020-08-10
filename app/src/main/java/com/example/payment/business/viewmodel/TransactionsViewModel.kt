package com.example.pagos.business.viewmodel

import android.app.Application
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import com.bumptech.glide.Glide
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
                .into(view)
        }

}

    fun getMethodPaymetList() : MutableLiveData<List<PaymentMethodsItem>> = geoRepository.fetchListPaymentMethods()

    fun getMethodCardIssuers() : MutableLiveData<List<CardIssuersItem>> = geoRepository.fetchListCurrentCardIssuers()

//    fun getMethodInstallment() : MutableLiveData<List<InstallmentItem>> = geoRepository.fetchListCurrentInstallments()


}