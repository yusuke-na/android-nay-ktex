/*
 * Created by Naaatan on 2021/09/04 17:46
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:46
 */

package nay.lib.ktex

import java.util.*

val String.asHexByteArray: ByteArray
    inline get() {
        val hexString = if (length % 2 == 0) this else "0$this"
        return hexString.chunked(2).map { it.uppercase(Locale.getDefault()).toInt(16).toByte() }
            .toByteArray()
    }

fun String.isNumber(): Boolean {
    if (isNullOrEmpty()) return false
    if (isBlank()) return false

    return if (toDoubleOrNull() != null) true else toLongOrNull() != null
}

inline fun <T> String.ifNumberNot(defaultValue: (String) -> T): String where T : Number, T : Comparable<T> =
    if (isNumber()) this else defaultValue(this).toString()

fun String.ifNumberNotNull(): String? = if (isNumber()) this else null