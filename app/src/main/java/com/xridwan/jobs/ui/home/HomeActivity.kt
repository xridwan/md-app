package com.xridwan.jobs.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xridwan.jobs.databinding.ActivityHomeBinding
import com.xridwan.jobs.room.StoreDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val db by lazy { StoreDb(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            val stores = db.storeDao().getStoreList() as ArrayList

            homeAdapter = HomeAdapter()
            homeAdapter.setData(stores)

            binding.rvStores.layoutManager = LinearLayoutManager(this@HomeActivity)
            binding.rvStores.setHasFixedSize(true)
            binding.rvStores.adapter = homeAdapter

            Log.e("onRoom", "onCreate: ${db.storeDao().getStoreList()}")
        }
    }
}