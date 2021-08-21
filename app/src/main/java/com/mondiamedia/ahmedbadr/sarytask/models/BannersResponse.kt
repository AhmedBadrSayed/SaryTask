package com.mondiamedia.ahmedbadr.sarytask.models

import com.google.gson.annotations.SerializedName

data class BannersResponse(
    @SerializedName("result") val bannersList: List<Banner>,
    @SerializedName("status") val status : Boolean
)
