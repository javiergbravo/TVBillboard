package com.jgbravo.tvbillboard.data.remote.responses.mappers

import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.data.remote.responses.BillboardResponse
import com.jgbravo.tvbillboard.data.remote.responses.models.ChannelModel

fun BillboardResponse.mapToChannelList(): List<Channel> {
    val list = ArrayList<Channel>()
    this.channelList?.let {
        it.forEach { channelModel ->
            channelModel.id?.let {
                val newChannel = channelModel.mapToChannel()
                if (newChannel.isNotNull()) {
                    list.add(newChannel)
                }
            }
        }
    }
    return list
}

fun ChannelModel.mapToChannel() = Channel(
    id = id!!,
    name = name ?: "",
    imageEndpoint = getEndpoint() ?: "",
    category = category ?: ""
)

fun ChannelModel.getEndpoint() : String? {
    attachments?.forEach {
        if(it.name.equals("LOGO")) {
            return it.value
        }
    }
    return null
}

fun Channel.isNotNull() = name.isNotEmpty() || imageEndpoint.isNotEmpty() || category.isNotEmpty()
