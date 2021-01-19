package com.jgbravo.tvbillboard.data.service

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.jgbravo.tvbillboard.data.remote.responses.BillboardResponse
import com.jgbravo.tvbillboard.data.remote.responses.LocalResponse
import com.jgbravo.tvbillboard.utils.Constants
import javax.inject.Inject

class BillboardService @Inject constructor(
    private val context: Context
) {

    private val TAG = "BillboardService"

    fun getAllChannels(): LocalResponse<BillboardResponse> {
        val json = context.assets.open(Constants.JSON_REPOSITORY).bufferedReader().use {
            it.readText()
        }
        Log.i(TAG, json)
        return try {
            val response = Gson().fromJson(json, BillboardResponse::class.java)
            Log.d(TAG, "BillboardResponse obtained successfully.")
            LocalResponse.success(response)
        } catch (e: JsonSyntaxException) {
            val errorMessage = "Error de sintaxis del JSON: ${e.message}."
            Log.e(TAG, errorMessage)
            LocalResponse.error(errorMessage, null)
        } catch (e: JsonParseException) {
            val errorMessage = "Error al convertir el JSON a un objeto BillboardResponse: ${e.message}."
            Log.e(TAG, errorMessage)
            LocalResponse.error(errorMessage, null)
        }
    }
}