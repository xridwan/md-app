package com.xridwan.jobs.network

import com.xridwan.jobs.helper.Helper.END_POINT
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST(END_POINT)
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Response<com.xridwan.jobs.model.Response>
}