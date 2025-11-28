package com.sopt.dive.Server


import com.sopt.dive.data.dto.response.ResponseSingleUserDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    @GET("/api/v1/users/{id}")
    fun getSingleUser(
        @Path("id") id: Int,
    ): Call<ResponseSingleUserDto>
}
