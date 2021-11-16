package com.xridwan.jobs.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Entity::class],
    version = 1
)
abstract class StoreDb: RoomDatabase() {
    abstract fun storeDao(): StoreDao

    companion object {
        @Volatile
        private var instance: StoreDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            StoreDb::class.java,
            "stores.db"
        ).build()
    }
}