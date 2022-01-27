package com.shashank.emp_assign.ui.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shashank.emp_assign.data.repository.Repository
import com.shashank.emp_assign.data.viewModel.MainViewModel

class ViewModelFactoryMainViewModelFactory( val PostalRepository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MainViewModel(PostalRepository) as T
    }
}