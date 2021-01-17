package com.jgbravo.tvbillboard.data.remote.responses.models

import com.google.gson.annotations.SerializedName

data class ChannelModel(
    @SerializedName("prLevel")
    val prLevel : Int?,
    @SerializedName("attachments")
    val attachments : List<AttachmentModel>?,
    @SerializedName("externalChannelId")
    val externalChannelId : Int?,
    @SerializedName("flags")
    val flags : Int?,
    @SerializedName("description")
    val description : String?,
    @SerializedName("bitrate")
    val bitrate : String?,
    @SerializedName("interactiveUrl")
    val interactiveUrl : String?,
    @SerializedName("responseElementType")
    val responseElementType : String?,
    @SerializedName("number")
    val number : Int?,
    @SerializedName("simultaneousViewsLimit")
    val simultaneousViewsLimit : String?,
    @SerializedName("affiliation")
    val affiliation : String?,
    @SerializedName("contentDefinition")
    val contentDefinition : String?,
    @SerializedName("id")
    val id : Int?,
    @SerializedName("serviceId")
    val serviceId : String?,
    @SerializedName("identifier")
    val identifier : String?,
    @SerializedName("ip")
    val ip : String?,
    @SerializedName("prName")
    val prName : String?,
    @SerializedName("originalNetworkId")
    val originalNetworkId : String?,
    @SerializedName("encoding")
    val encoding : String?,
    @SerializedName("url")
    val url : String?,
    @SerializedName("transportStreamId")
    val transportStreamId : String?,
    @SerializedName("port")
    val port : Int?,
    @SerializedName("sourceType")
    val sourceType : String?,
    @SerializedName("name")
    val name : String?,
    @SerializedName("extrafields")
    val extrafields : List<ExtraFieldModel>?,
    @SerializedName("category")
    val category : String?,
    @SerializedName("longName")
    val longName : String?
)
