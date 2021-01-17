package com.jgbravo.tvbillboard.data.remote.responses

import com.google.gson.annotations.SerializedName
import com.jgbravo.tvbillboard.data.remote.responses.models.ChannelModel
import com.jgbravo.tvbillboard.data.remote.responses.models.MetadataModel

data class BillboardResponse(
    @SerializedName("metadata")
    val metadata : MetadataModel?,
    @SerializedName("response")
    val channelList : List<ChannelModel>?
)
