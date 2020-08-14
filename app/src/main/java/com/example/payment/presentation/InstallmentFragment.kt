package com.example.payment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.pagos.PRODUCT_LIST
import com.example.pagos.R
import com.example.pagos.business.viewmodel.TransactionsViewModel
import com.example.pagos.business.viewmodel.TransactionsViewModel_Factory
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.databinding.FragmentInstallmentBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_installment.*
import javax.inject.Inject

class InstallmentFragment : DaggerFragment() {

    @Inject
    lateinit var mySharePreferences: MySharePreferences

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var transactionsViewModel: TransactionsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInstallmentBinding>(
            inflater, R.layout.fragment_installment, container, false)

         transactionsViewModel = activity?.let {
            ViewModelProviders.of(this, viewModelFactory)[TransactionsViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val chosenProduct = arguments?.getParcelable<CardIssuersItem>(PRODUCT_LIST)
        binding.paymentRow = chosenProduct
        binding.buttonSend.setOnClickListener {
            mySharePreferences.putData("ID", chosenProduct!!.id)
            mySharePreferences.putAmount("AMOUNT", Integer.parseInt(edittext_amount.text.toString()))
            transactionsViewModel.getMethodInstallment().observe(this, Observer {

            })
        }
        return  binding.root
    }

    companion object {
        fun newInstance() =
            InstallmentFragment()
    }

}