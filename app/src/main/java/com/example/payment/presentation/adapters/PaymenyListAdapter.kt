package com.example.pagos.presentation

import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagos.data.methodspaymentresponse.PaymentMethodsItem
import com.example.pagos.databinding.RecycleviewPaymentItemBinding

class PaymenyListAdapter constructor(context: Context, val clickListener : PaymentListener ):
    RecyclerView.Adapter<PaymenyListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var data = emptyList<PaymentMethodsItem>()


    inner class WordViewHolder(val binding: RecycleviewPaymentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(paymentMethods: PaymentMethodsItem, clickListener : PaymentListener) {
                with(binding) {
                binding.textViewName.text = Editable.Factory.getInstance().newEditable(paymentMethods.name)
               Glide.with(binding.imageViewCar.context)
                   .load(paymentMethods.thumbnail)
                   .into(imageViewCar)
                   binding.clickListener = clickListener
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = RecycleviewPaymentItemBinding.inflate(inflater, parent, false)
        return WordViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PaymenyListAdapter.WordViewHolder, position: Int) {
        holder.bind( data[position], clickListener)
    }

    internal fun setData(data: List<PaymentMethodsItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    class PaymentListener(val clickListener : (PaymentMethodsId : String) -> Unit) {
        fun onClick(paymentMethodsItem: PaymentMethodsItem) = clickListener(paymentMethodsItem.id)
    }

}








