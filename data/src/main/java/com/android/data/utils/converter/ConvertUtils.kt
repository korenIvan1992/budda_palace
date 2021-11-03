package com.android.data.utils.converter

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object ConvertUtils {
    fun dpFromPx(px: Float, context: Context): Float {
        return px / context.resources.displayMetrics.density
    }

    fun pxFromDp(dp: Float, context: Context): Float {
        return dp * context.resources.displayMetrics.density
    }

    fun convertObjToString(clsObj: Any?): String {
        //convert object  to string json
        return Gson().toJson(clsObj, object : TypeToken<Any?>() {}.type)
    }

    fun <T> convertStringToObj(strObj: String?, classOfT: Class<T>?): T {
        //convert string json to object
        return Gson().fromJson(strObj, classOfT as Type?)
    }
}