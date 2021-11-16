package com.xridwan.jobs.model

import com.xridwan.jobs.room.Store

data class Response(
    val stores: ArrayList<Store>,
    val status: String,
    val message: String
)
