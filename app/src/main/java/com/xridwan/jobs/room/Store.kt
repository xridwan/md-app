package com.xridwan.jobs.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Store(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val store_id: Int,
    val store_name: String
): Parcelable