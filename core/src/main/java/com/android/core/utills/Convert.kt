package com.android.core.utills

import android.content.Context
import java.security.MessageDigest

object Convertor {

    fun dpFromPx(context: Context?, px: Int): Float {
        return (px / context!!.resources.displayMetrics.density).toInt().toFloat()
    }

    fun pxFromDp(context: Context, dp: Int): Float {
        return (dp * context.resources.displayMetrics.density).toInt().toFloat()
    }

}


