package com.example.pagos.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethodsItem
import com.example.pagos.databinding.RecycleviewPaymentItemBinding

class ListAdapterCard constructor(context: Context, val clickListener : ItemClickListener ):
    RecyclerView.Adapter<ListAdapterCard.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var data = emptyList<CardIssuersItem>()


    inner class WordViewHolder(val binding: RecycleviewPaymentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardIssuersItem: CardIssuersItem, clickListener : ItemClickListener) {
            binding.textViewName.text = cardIssuersItem.name
            binding.list = cardIssuersItem
            binding.payment = cardIssuersItem
            Glide.with(binding.imageViewCar.context)
                .load(cardIssuersItem.thumbnail)
                .into(binding.imageViewCar)
            binding.clickListener = clickListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = RecycleviewPaymentItemBinding.inflate(inflater, parent, false)
        return WordViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListAdapterCard.WordViewHolder, position: Int) {
        holder.bind( data[position], clickListener)
    }

    internal fun setData(data: List<CardIssuersItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    interface ItemClickListener{
        fun itemClicked(cardIssuersItem: CardIssuersItem)
    }

}








