package com.jgbravo.tvbillboard.data.remote.responses.models

import com.google.gson.annotations.SerializedName

data class ExtraFieldModel(
    @SerializedName("responseElementType")
    val responseElementType: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: Int?
)