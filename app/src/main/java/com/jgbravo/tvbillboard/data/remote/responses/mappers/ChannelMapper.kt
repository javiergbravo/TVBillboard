package com.jgbravo.tvbillboard.data.remote.responses.mappers

import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.data.remote.responses.BillboardResponse
import com.jgbravo.tvbillboard.data.remote.responses.models.ChannelModel

fun BillboardResponse.mapToChannelList(): List<Channel> {
    val channelList = ArrayList<Channel>()
    this.channelList?.let {
        it.forEach { channelModel ->
            val newChannel = channelModel.mapToChannel()
            if (!newChannel.isNull()) {
                channelList.add(newChannel)
            }
        }
    }
    return channelList
}

fun ChannelModel.mapToChannel() = Channel(
    name = name ?: "",
    imageURL = url ?: "",
    category = category ?: ""
)

fun Channel.isNull() =
    name.isNotEmpty() || imageURL.isNullOrEmpty() || category.isNullOrEmpty()