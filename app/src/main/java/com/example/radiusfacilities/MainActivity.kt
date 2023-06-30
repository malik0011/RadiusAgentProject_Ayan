package com.example.radiusfacilities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.radiusfacilities.adapter.FacilitiesAdapter
import com.example.radiusfacilities.adapter.OptionsAdapter
import com.example.radiusfacilities.databinding.ActivityMainBinding
import com.example.radiusfacilities.viewmodels.MainViewModel
import com.example.radiusfacilities.viewmodels.MainViewModelFactory
//use to listen clicks form adapter
interface onClickListner {
    fun onClick(obj: Any)
}
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private val adapter: FacilitiesAdapter by lazy { FacilitiesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initRepository()
        initRecyclerView()
        setObservers()
    }

    private fun initRecyclerView() {
       binding.rcv.layoutManager = LinearLayoutManager(applicationContext)
        binding.rcv.adapter = adapter
    }

    private fun setObservers() {
        mainViewModel.facilitiesData.observe(this) {
            //hiding progressBar on dat load
            binding.progressBar.isVisible = false
            adapter.submitList(it.facilities)
        }
    }

    private fun initRepository() {
        val repository = (application as RadiusApplication).facilitiesDataRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]
    }

}