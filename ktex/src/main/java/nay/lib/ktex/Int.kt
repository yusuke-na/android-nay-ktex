/*
 * Created by Naaatan on 2021/09/04 17:45
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:45
 */

package nay.lib.ktex

import java.math.BigDecimal

fun Int.hasFlag(flag: Int) = flag and this == flag

fun Int.toByteArray() = byteArrayOf(0x00, 0x00, 0x00, 0x00).let {
    it[0] = ((this and 0xFF000000.toInt()) shr 24).toByte()
    it[1] = ((this and 0x00FF0000) shr 16).toByte()
    it[2] = ((this and 0x0000FF00) shr 8).toByte()
    it[3] = (this and 0x000000FF).toByte()
    it
}

/**
 * Move the decimal point to the left (10 ^ -[move])
 */
fun Int.movePointLeft(move: Int): BigDecimal =
    this.toBigDecimal().movePointLeft(move)

/**
 * Move the decimal point to the right (10 ^ [move])
 */
fun Int.movePointRight(move: Int): BigDecimal =
    this.toBigDecimal().movePointRight(move)