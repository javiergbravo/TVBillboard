package com.jgbravo.tvbillboard.data.remote.responses.models

import com.google.gson.annotations.SerializedName

data class MetadataModel(
    @SerializedName("request")
    val request : String?,
    @SerializedName("fullLength")
    val fullLength : Int?,
    @SerializedName("timestamp")
    val timestamp : Long?
)
