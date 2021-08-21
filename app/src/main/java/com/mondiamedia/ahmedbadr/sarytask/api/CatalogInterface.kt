package com.mondiamedia.ahmedbadr.sarytask.api

import CatalogResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatalogInterface {

    @Headers(
        "Device-Type: android",
        "App-Version: 3.1.1.0.0",
        "Accept-Language: en",
        "Authorization: token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ODg2NiwidXNlcl9waG9uZSI6Ijk2NjU2NDk4OTI1MCJ9.VYE28vtnMRLmwBISgvvnhOmPuGueW49ogOhXm5ZqsGU"
    )
    @GET("/api/baskets/76097/catalog/")
    suspend fun getCatalog(): CatalogResponse
}