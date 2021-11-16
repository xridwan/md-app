package com.xridwan.jobs.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.xridwan.jobs.databinding.ActivityMainBinding
import com.xridwan.jobs.room.StoreDb
import com.xridwan.jobs.ui.home.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val db by lazy { StoreDb(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tv1.setOnClickListener {
            viewModel.login("pitjarus", "admin").observe(this, {
                CoroutineScope(Dispatchers.Main).launch {
                    db.storeDao().insert(it.stores)
                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                }
            })
        }
    }
}