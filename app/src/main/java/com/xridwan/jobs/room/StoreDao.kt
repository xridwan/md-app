package com.xridwan.jobs.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StoreDao {

    @Query("SELECT count(*) FROM Entity")
    suspend fun getCount(): Int

    @Query("SELECT * FROM Entity WHERE id= :id")
    suspend fun getStore(id: Int): Entity

    @Query("SELECT * FROM Entity")
    suspend fun getStoreList(): List<Entity>

    @Insert
    suspend fun insertStore(store: List<Entity>)
}