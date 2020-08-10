package com.example.pagos

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagos.business.viewmodel.TransactionsViewModel
import com.example.pagos.data.issuerscardresponse.CardIssuersItem
import com.example.pagos.data.methodspaymentresponse.PaymentMethods
import com.example.pagos.databinding.ActivityMainBinding
import com.example.pagos.presentation.CardIssuersListAdapter
import com.example.pagos.presentation.ListAdapterCard
import com.example.payment.presentation.InstallmentFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlin.collections.ArrayList

const val PRODUCT_LIST = "productList"
class MainActivity  : DaggerAppCompatActivity(), ListAdapterCard.ItemClickListener {
//    https://stackoverflow.com/questions/49949724/kotlin-how-to-return-a-generic-type-member-variable

    private val listPayment: MutableList<PaymentMethods> = ArrayList()
    private val listCardIssues: MutableList<CardIssuersItem> = ArrayList()
    private val listName: MutableList<String> = ArrayList()
    private val listCard: MutableList<String> = ArrayList()
    private lateinit var adapterListCard: ListAdapterCard
    private lateinit var adaptercardlIssues: CardIssuersListAdapter
    private var recyclerView: RecyclerView? = null


    val entries: ObservableField<List<String>> = ObservableField()


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val transactionsViewModel: TransactionsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[TransactionsViewModel::class.java]

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context: Context = this@MainActivity
        binding.viewmodel = transactionsViewModel
        transactionsViewModel.getMethodPaymetList().observe(this, Observer {
//            listPaymentMethods(it)
//            adapterPaymenyList.setData(it)

        })
        transactionsViewModel.getMethodCardIssuers().observe(this, Observer {
            adapterListCard.setData(it)
        })

        adapterListCard = ListAdapterCard(this, this)

        adaptercardlIssues = CardIssuersListAdapter(this)

        recyclerView = binding.recyclerviewPaymentList
        binding.recyclerviewPaymentList.adapter = adapterListCard
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

    override fun itemClicked(cardIssuersItem: CardIssuersItem) {
        try {
            Log.e(
                "METODO",
                "PASO POR EL METODO DEL ITEMCLICK MAIN" + " El id clikqueado es:  " + cardIssuersItem.id
            )
            val fragmentBlank = InstallmentFragment.newInstance()
            val args = Bundle()
            args.putParcelable(PRODUCT_LIST, cardIssuersItem)
            fragmentBlank.arguments = args
            val installmentfragment = supportFragmentManager?.beginTransaction()
            installmentfragment?.add(R.id.fragmentContainer, fragmentBlank)
            installmentfragment?.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}


