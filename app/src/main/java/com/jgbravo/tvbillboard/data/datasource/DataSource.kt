package com.jgbravo.tvbillboard.data.datasource

import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.data.remote.responses.LocalResponse

interface DataSource {

    fun getChannelList(): LocalResponse<List<Channel>>
}