package com.xridwan.jobs.model

import com.xridwan.jobs.room.Entity

data class Response(
    val stores: ArrayList<Entity>,
    val status: String,
    val message: String
)
