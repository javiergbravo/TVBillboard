package com.jgbravo.tvbillboard.data.datasource

import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.data.remote.responses.LocalResponse
import com.jgbravo.tvbillboard.data.remote.responses.mappers.mapToChannelList
import com.jgbravo.tvbillboard.data.service.BillboardService
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val service: BillboardService
) : DataSource {

    override fun getChannelList(): LocalResponse<List<Channel>> {
        val response = service.getAllChannels()
        if (response.status == LocalResponse.Status.SUCCESS) {
            if (response.data?.channelList == null) {
                return LocalResponse.error(
                    "No se han podido recuperar correctamente los canales.",
                    null
                )
            }
            val channelList = response.data.mapToChannelList()
            return LocalResponse.success(channelList)
        } else {
            return LocalResponse.error(response.message!!, null)
        }
    }
}