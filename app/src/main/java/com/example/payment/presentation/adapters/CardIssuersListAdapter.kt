


 package com.example.pagos.presentation

import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.databinding.RecycleviewPaymentItemBinding

 class CardIssuersListAdapter constructor(val context: Context):
    RecyclerView.Adapter<CardIssuersListAdapter.cardlIssuesViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var data = emptyList<CardIssuersItem>()


    inner class cardlIssuesViewHolder(val binding: RecycleviewPaymentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardIssuersItem: CardIssuersItem ) {
                with(binding) {
                binding.textViewName.text = Editable.Factory.getInstance().newEditable(cardIssuersItem.name)
               Glide.with(binding.imageViewCar.context)
                   .load(cardIssuersItem.thumbnail)
                   .into(imageViewCar)
//                    binding.clickListener = clickListener
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardlIssuesViewHolder {
        val binding = RecycleviewPaymentItemBinding.inflate(inflater, parent, false)
        return cardlIssuesViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CardIssuersListAdapter.cardlIssuesViewHolder, position: Int) {
        holder.bind( data[position])
    }

    internal fun setData(data: List<CardIssuersItem>) {
        this.data = data
        notifyDataSetChanged()
    }

//    class PaymentListener(val clickListener : (PaymentMethodsId : String) -> Unit) {
//        fun onClick(paymentMethods: PaymentMethods) = clickListener(paymentMethods.id)
//    }

}
/*
package com.example.pagos.presentation

import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagos.R
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethods
import com.example.pagos.databinding.RecycleviewPaymentItemBinding
import com.example.pagos.presentation.spinnerdata.ObjectSelected

class CardIssuersListAdapter internal constructor(
    private val mCardlIssues : List<CardIssuersItem>,
    private val  mlistener : ObjectSelected):
    RecyclerView.Adapter<CardIssuersListAdapter.cardlIssuesViewHolder>() {

//    private val inflater: LayoutInflater = LayoutInflater.from(context)
//    var data = emptyList<PaymentMethods>()
//    private val listener: ObjectSelected? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardlIssuesViewHolder = cardlIssuesViewHolder.from(parent)

    override fun getItemCount(): Int = mCardlIssues.size

    override fun onBindViewHolder(holder: cardlIssuesViewHolder, position: Int) = holder.bind( mCardlIssues[position], mlistener )


   class cardlIssuesViewHolder(val binding: RecycleviewPaymentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cardIssuersItem: CardIssuersItem, listerner : ObjectSelected ) {
                with(binding) {
                binding.textViewName.text = Editable.Factory.getInstance().newEditable(cardIssuersItem.name)
               Glide.with(binding.imageViewCar.context)
                   .load(cardIssuersItem.thumbnail)
                   .into(imageViewCar)
                    binding.clickListener = listerner
                    binding.executePendingBindings()
            }
        }

       companion object {
           fun from(parent: ViewGroup): cardlIssuesViewHolder {
               val layoutInflater = LayoutInflater.from(parent.context)
               val binding: RecycleviewPaymentItemBinding = DataBindingUtil
                   .inflate(layoutInflater, R.layout.recycleview_payment_item,
                       parent, false)
               return cardlIssuesViewHolder(binding)
           }
       }
   }

    }
 */



//    internal fun setData(mPayment: List<PaymentMethods>) {
//        mPayment = mPayment
//        notifyDataSetChanged()
//    }



//    class PaymentListener(val clickListener : (PaymentMethodsId : String) -> Unit) {
//        fun onClick(paymentMethods: PaymentMethods) = clickListener(paymentMethods.id)
//    }

