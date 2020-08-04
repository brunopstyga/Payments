package com.example.practicaskotlin.data.model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pagos.business.viewmodel.TransactionsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TransactionsViewModel::class)
    abstract fun bindMainViewModel(transactionsViewModel: TransactionsViewModel): ViewModel
}