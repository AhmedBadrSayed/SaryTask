package com.mondiamedia.ahmedbadr.sarytask.models

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("button_text") val buttonText: String,
    @SerializedName("expiry_status") val expiryStatus: Boolean,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("expiry_date") val expiryDate: String,
    @SerializedName("image") val image: String,
    @SerializedName("priority") val priority: Int,
    @SerializedName("photo") val photo: String,
    @SerializedName("link") val link: String,
    @SerializedName("level") val level: String,
    @SerializedName("is_available") val isAvailable: Boolean,
    @SerializedName("branch") val branch: Int
)
