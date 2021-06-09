package com.android.buddhapalace.quotes.ui.allglobal.extentions

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * @author koren_ivan 2019 */

fun <T : Fragment> T.withArgs(block: Bundle.() -> Unit): T {
    return this.apply {
        arguments = Bundle().apply(block)
    }
}

var View.visible: Boolean
    get() = this.visibility == View.VISIBLE
    set(value) = if (value) this.visibility = View.VISIBLE else this.visibility = View.GONE


fun ViewGroup.inflate(layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)


fun View.isVisible(): Boolean = visibility == View.VISIBLE

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisibleOrGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.makeVisibleOrInvisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

fun setTextHTML(html: String): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    else
        Html.fromHtml(html)
}

inline fun View.onClick(crossinline callback: () -> Unit): Unit =
    setOnClickListener { callback.invoke() }


fun rateGoogle(context: Context) {
    val appPackageName = context.packageName
    try {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=$appPackageName")
            )
        )
    } catch (anfe: android.content.ActivityNotFoundException) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
            )
        );
    }
}






