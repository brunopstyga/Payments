package com.example.payment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pagos.PRODUCT_LIST
import com.example.pagos.R
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.databinding.FragmentInstallmentBinding

class InstallmentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInstallmentBinding>(
            inflater, R.layout.fragment_installment, container, false)
//        return inflater.inflate(R.layout.fragment_installment, container, false)
        val chosenProduct = arguments?.getParcelable<CardIssuersItem>(PRODUCT_LIST)
        binding.paymentRow = chosenProduct
        return  binding.root
    }

    companion object {
        fun newInstance() =
            InstallmentFragment()
    }

}