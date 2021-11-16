package com.xridwan.jobs.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StoreDao {

    @Query("SELECT count(*) FROM Store")
    suspend fun getCount(): Int

    @Query("SELECT * FROM Store WHERE id= :id")
    suspend fun getStore(id: Int): Store

    @Query("SELECT * FROM Store")
    suspend fun getStoreList(): List<Store>

    @Insert
    suspend fun insert(store: List<Store>)
}