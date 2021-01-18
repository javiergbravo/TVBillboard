package com.jgbravo.tvbillboard.data.entities

data class Channel(
    val id: Long,
    val name: String,
    val imageEndpoint: String,
    val category: String
)