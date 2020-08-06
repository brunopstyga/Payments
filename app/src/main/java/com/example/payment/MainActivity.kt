package com.example.pagos

import android.content.Context
import android.os.Bundle
import androidx.databinding.ObservableField
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagos.business.viewmodel.TransactionsViewModel
import com.example.pagos.data.GetListDataApi
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethods
import com.example.pagos.data.methodspaymentresponse.PaymentMethodsItem
import com.example.pagos.databinding.ActivityMainBinding
import com.example.pagos.presentation.CardIssuersListAdapter
import com.example.pagos.presentation.PaymenyListAdapter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlin.collections.ArrayList


class MainActivity  : DaggerAppCompatActivity(){
//    https://stackoverflow.com/questions/49949724/kotlin-how-to-return-a-generic-type-member-variable
//    private lateinit var binding: ActivityMainBinding
    private val listPayment : MutableList<PaymentMethods> = ArrayList()
    private val listCardIssues : MutableList<CardIssuersItem> = ArrayList()
    private val listName : MutableList<String> = ArrayList()
    private val listCard : MutableList<String> = ArrayList()
   private lateinit var adapterPaymenyList: PaymenyListAdapter
    private lateinit var adaptercardlIssues: CardIssuersListAdapter
    private var recyclerView: RecyclerView? = null



//    private val context = getApplication<Application>().applicationContext

    val entries : ObservableField<List<String>> = ObservableField()


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

//    private val dataPaymMethos: DataPaymMethos by lazy {
//        DataPaymMethos(listPayment)
//    }


    private val transactionsViewModel: TransactionsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[TransactionsViewModel::class.java]

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context: Context = this@MainActivity
        binding.viewmodel = transactionsViewModel
        transactionsViewModel.getMethodPaymetList().observe(this, Observer {
//            listPaymentMethods(it)
            adapterPaymenyList.setData(it)

        })
        transactionsViewModel.getMethodCardIssuers().observe(this, Observer {
//            listCardIssues(it)
            adaptercardlIssues.setData(it)
        })
//        transactionsViewModel.getMethodInstallment().observe(this, Observer {
//
//        })
//         binding.viewmodel?.showUpdatedPaymentMethos()
         adapterPaymenyList = PaymenyListAdapter(this , PaymenyListAdapter.PaymentListener {
             transactionsViewModel.onPaymentClicked(it)
         })
         adaptercardlIssues = CardIssuersListAdapter(this)
//        val arrayAdapter = ArrayAdapter(applicationContext, R.layout.simple_spinner_item, listName)

//        adaptercardlIssues.setData(listCardIssues)
        recyclerView = binding.recyclerviewPaymentList
        binding.recyclerviewPaymentList.adapter = adapterPaymenyList
        binding.recyclerviewCardIssuers.adapter = adaptercardlIssues
        binding.recyclerviewPaymentList.layoutManager = LinearLayoutManager(context)



    }

/*
  // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
 */

    override fun onResume() {
        super.onResume()

    }

//    override fun listPaymentMethods(paymentList: List<PaymentMethodsItem>) {
//        paymentList.forEach {
//            listPayment.add(PaymentMethods(it.id.toString(),it.name.toString(),
//                it.paymentTypeId.toString(),it.status.toString(), it.thumbnail.toString()))
//        }
//        listPayment.forEach {
//            listName.add(it.name.toString())
//        }
////        select(listPayment)
//    }
//
//    override fun listCardIssues(cardIssuersItem: List<CardIssuersItem>) {
//        cardIssuersItem.forEach {
//            listCardIssues.add(CardIssuersItem(it.id.toString(),it.name.toString(),
//                it.secureThumbnail.toString(),it.secureThumbnail.toString(),"",""))
//        }
//        cardIssuersItem.forEach {
//            listCard.add(it.name.toString())
//        }
//    }


    }
//fun cualqioera(){
//    val adapterPaymenyList = PaymenyListAdapter(listPayment,this)
//    val adaptercardlIssues = CardIssuersListAdapter(listCardIssues,this)
//}



