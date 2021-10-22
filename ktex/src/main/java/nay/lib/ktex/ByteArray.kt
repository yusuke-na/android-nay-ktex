/*
 * Created by Naaatan on 2021/09/04 17:45
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:45
 */

package nay.lib.ktex

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*

fun ByteArray.toHex(isReverse: Boolean = false): String = map { String.format("%02x", it) }
    .let { if (isReverse) it.asReversed() else it }
    .joinToString("")

fun ByteArray.toHexWithPrefix(isReverse: Boolean = false, zeroPadding: Int = 2): String {
    val sHex = map { byte -> String.format("%02x", byte).uppercase(Locale.ROOT) }
        .let { if (isReverse) it.asReversed() else it }
        .joinToString("")
        .dropWhile { it == '0' }
        .padStart(zeroPadding, '0')
        .let { if (it.isEmpty()) "0" else it }

    return "0x$sHex"
}

fun ByteArray.toLong(isReverse: Boolean = false) =
    runCatching {
        toHex(isReverse = isReverse).toLong(16)
    }.getOrElse { error ->
        when (error) {
            is NumberFormatException -> {
                val order = if (isReverse) ByteOrder.LITTLE_ENDIAN else ByteOrder.BIG_ENDIAN
                ByteBuffer.wrap(this).order(order).long
            }
            else -> throw error
        }
    }

fun ByteArray.toInt(isReverse: Boolean = false) =
    runCatching {
        toHex(isReverse = isReverse).toInt(16)
    }.getOrElse { error ->
        when (error) {
            is NumberFormatException -> {
                val order = if (isReverse) ByteOrder.LITTLE_ENDIAN else ByteOrder.BIG_ENDIAN
                ByteBuffer.wrap(this).order(order).int
            }
            else -> throw error
        }
    }

fun ByteArray.toShort(isReverse: Boolean = false) =
    runCatching {
        toHex(isReverse = isReverse).toShort(16)
    }.getOrElse { error ->
        when (error) {
            is NumberFormatException -> {
                val order = if (isReverse) ByteOrder.LITTLE_ENDIAN else ByteOrder.BIG_ENDIAN
                ByteBuffer.wrap(this).order(order).short
            }
            else -> throw error
        }
    }

fun ByteArray.toFloat(isReverse: Boolean = false) =
    if (isReverse) {
        ByteBuffer.wrap(this).order(ByteOrder.LITTLE_ENDIAN).float
    } else {
        ByteBuffer.wrap(this).order(ByteOrder.BIG_ENDIAN).float
    }

fun ByteArray.toDouble(isReverse: Boolean = false) =
    if (isReverse) {
        ByteBuffer.wrap(this).order(ByteOrder.LITTLE_ENDIAN).double
    } else {
        ByteBuffer.wrap(this).order(ByteOrder.BIG_ENDIAN).double
    }

fun ByteArray.copyWithLength(fromIndex: Int, length: Int) = copyOfRange(fromIndex, fromIndex + length)