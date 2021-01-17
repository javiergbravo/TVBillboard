package com.jgbravo.tvbillboard.ui.billboard.activity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgbravo.tvbillboard.data.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BillboardViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _billboardList = MutableStateFlow<UIState>(UIState.NotStarted)
    val billboardList: StateFlow<UIState> = _billboardList

    init {
        getBillboard()
    }

    fun getBillboard() = viewModelScope.launch {
        _billboardList.value = UIState.Loading
        // val billboard = repository.getBillboard()
        // TODO: if (is successful) {
    }
}