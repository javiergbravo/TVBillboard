package com.jgbravo.tvbillboard.data.datasource

import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.data.entities.Resource

interface DataSource {

    fun getChannelList(): Resource<List<Channel>>
}