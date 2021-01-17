package com.jgbravo.tvbillboard.data

open class UIState {
    object NotStarted : UIState()
    object Loading : UIState()
    object Success : UIState()
    data class Error(val message: String) : UIState()
}