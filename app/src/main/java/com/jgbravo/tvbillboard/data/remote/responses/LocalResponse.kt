package com.jgbravo.tvbillboard.data.remote.responses

data class LocalResponse<out T>(
    val status: Status,
    val body: T?,
    val message: String?
) {

    enum class Status {
        SUCCESS,
        ERROR,
    }

    companion object {
        fun <T> success(body: T?): LocalResponse<T> {
            return LocalResponse(Status.SUCCESS, body, null)
        }

        fun <T> error(msg: String, body: T?): LocalResponse<T> {
            return LocalResponse(Status.ERROR, body, msg)
        }
    }
}