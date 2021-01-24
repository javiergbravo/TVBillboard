package com.jgbravo.tvbillboard.ui.billboard.activity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.jgbravo.tvbillboard.data.datasource.DataSourceImpl
import com.jgbravo.tvbillboard.data.entities.Channel
import com.jgbravo.tvbillboard.data.entities.Resource
import kotlinx.coroutines.launch

class BillboardViewModel @ViewModelInject constructor(
    private val datasource: DataSourceImpl,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _channelList = MutableLiveData<Resource<List<Channel>>>()
    val channelList: LiveData<Resource<List<Channel>>> get() = _channelList

    var allCategories = ArrayList<String>()

    init {
        getBillboard()
    }

    fun getBillboard() = viewModelScope.launch {
        _channelList.postValue(Resource.loading())
        val resource = datasource.getChannelList()
        if (resource.state == Resource.State.SUCCESS) {
            resource.data?.let { setCategories(it) }
            _channelList.postValue(Resource.success(resource.data))
        } else {
            _channelList.postValue(Resource.error(resource.message!!, null))
        }
    }

    private fun setCategories(channels: List<Channel>) {
        channels.forEach {
            if (!allCategories.contains(it.category)) {
                allCategories.add(it.category)
            }
        }
    }
}