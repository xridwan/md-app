package com.xridwan.jobs.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.xridwan.jobs.R
import com.xridwan.jobs.room.StoreDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private val db by lazy {  StoreDb(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        CoroutineScope(Dispatchers.Main).launch {
            db.storeDao().getStoreList()
            Log.e("onRoom", "onCreate: ${db.storeDao().getStoreList()}", )
        }
    }
}