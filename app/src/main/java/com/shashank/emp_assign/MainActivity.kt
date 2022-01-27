package com.shashank.emp_assign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashank.emp_assign.adapter.PostalPlaceAdapter
import com.shashank.emp_assign.data.repository.Repository
import com.shashank.emp_assign.data.utils.Resource
import com.shashank.emp_assign.data.viewModel.MainViewModel
import com.shashank.emp_assign.ui.ViewModelFactory.ViewModelFactoryMainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel: MainViewModel
    lateinit var newsAdapter: PostalPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupRecyclerview()
        val repository= Repository()
        val viewModelFactory =  ViewModelFactoryMainViewModelFactory(repository)
        viewmodel= ViewModelProvider(this,viewModelFactory)
            .get(MainViewModel::class.java)




        getBtn.setOnClickListener {
            if(TextUtils.isEmpty(etSearch.text.toString())){
                Toast.makeText(this, "Please enter pincode", Toast.LENGTH_SHORT).show()
            }

            viewmodel.getAllData(etSearch.text.toString())

        }



        viewmodel.myresponse.observe(this ,Observer { response ->
            when(response){
                is Resource.Success ->{

                    response.data?.let {  newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.places)
                    }
                }
                is Resource.Error -> {

                    response.message?.let { message->

                        Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })




    }
    private fun setupRecyclerview() {
        newsAdapter= PostalPlaceAdapter()
        rv.apply {
            adapter=newsAdapter
            layoutManager= LinearLayoutManager(this@MainActivity)
        }

    }
}