package com.jgbravo.tvbillboard.data.remote.responses

data class LocalResponse<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {
    enum class Status {
        SUCCESS,
        ERROR,
    }

    companion object {
        fun <T> success(data: T?): LocalResponse<T> {
            return LocalResponse(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): LocalResponse<T> {
            return LocalResponse(Status.ERROR, data, msg)
        }
    }
}