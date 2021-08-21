package com.mondiamedia.ahmedbadr.sarytask.api

import com.mondiamedia.ahmedbadr.sarytask.models.BannersResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface BannersInterface {

    @Headers(
        "Device-Type: android",
        "App-Version: 3.1.1.0.0",
        "Accept-Language: en",
        "Authorization: token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ODg2NiwidXNlcl9waG9uZSI6Ijk2NjU2NDk4OTI1MCJ9.VYE28vtnMRLmwBISgvvnhOmPuGueW49ogOhXm5ZqsGU"
    )
    @GET("/api/v2.5.1/baskets/76097/banners/")
    suspend fun getBanners(): BannersResponse
}