package com.jgbravo.tvbillboard.ui.billboard.activity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgbravo.tvbillboard.data.UIState
import com.jgbravo.tvbillboard.data.datasource.DataSourceImpl
import com.jgbravo.tvbillboard.data.remote.responses.LocalResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BillboardViewModel @ViewModelInject constructor(
    private val datasource: DataSourceImpl,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _billboardList = MutableStateFlow<UIState>(UIState.NotStarted)
    val billboardList: StateFlow<UIState> = _billboardList

    init {
        getBillboard()
    }

    fun getBillboard() = viewModelScope.launch {
        _billboardList.value = UIState.Loading
        val response = datasource.getChannelList()
        if (response.status == LocalResponse.Status.SUCCESS) {
            _billboardList.value = UIState.Success
        } else {
            _billboardList.value = UIState.Error("Ha habido un error al obtener los canales.")
        }
    }
}