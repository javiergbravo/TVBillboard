package com.jgbravo.tvbillboard.data.remote.responses.models

import com.google.gson.annotations.SerializedName

data class AttachmentModel(
    @SerializedName("responseElementType")
    val responseElementType: String?,
    @SerializedName("assetId")
    val assetId: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("assetName")
    val assetName: String?,
    @SerializedName("value")
    val value: String?
)