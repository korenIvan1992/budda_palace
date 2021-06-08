package com.android.core.extensions

import java.math.BigDecimal
import java.math.RoundingMode

fun <T> Iterable<T>.sumByBigDecimal(selector: (T) -> BigDecimal): BigDecimal {
    var sum = BigDecimal(0.00)
    for (element in this) {
        sum += selector(element)
    }

    return sum
}

fun BigDecimal.normalize(): BigDecimal {
    return this
        .setScale(3, RoundingMode.DOWN)
        .setScale(2, RoundingMode.HALF_UP)
}

fun BigDecimal.isZero() = this.signum() == 0

fun BigDecimal.isLessZero() = this.signum() == -1

fun BigDecimal.isGreaterZero() = this.signum() == 1

fun BigDecimal.format(precision: Int=2): String {
    return "%.${precision}f".format(this)
}