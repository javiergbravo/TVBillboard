package com.jgbravo.tvbillboard.data.datasource

import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.data.entities.Resource
import com.jgbravo.tvbillboard.data.remote.responses.LocalResponse
import com.jgbravo.tvbillboard.data.remote.responses.mappers.mapToChannelList
import com.jgbravo.tvbillboard.data.service.BillboardService
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val service: BillboardService
) : DataSource {

    override fun getChannelList(): Resource<List<Channel>> {
        val response = service.getAllChannels()
        if (response.status == LocalResponse.Status.SUCCESS) {
            if (response.body?.channelList == null) {
                return Resource.error(
                    "No se han podido recuperar correctamente los canales.",
                    null
                )
            }
            val channelList = response.body.mapToChannelList()
            return Resource.success(channelList)
        } else {
            return Resource.error(response.message!!, null)
        }
    }
}