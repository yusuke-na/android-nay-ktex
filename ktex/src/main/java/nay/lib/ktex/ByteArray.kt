/*
 * Created by Naaatan on 2021/09/04 17:45
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:45
 */

package nay.lib.ktex

import java.nio.ByteBuffer

fun ByteArray.toHex(): String = asUByteArray().joinToString {
    it.toString(radix = 16).padStart(2, '0')
}

fun ByteArray.toHexWithPrefix(): String = "0x%s".format(toHex())

fun ByteArray.toLong(): Long = ByteBuffer.wrap(this).long

fun ByteArray.toInt(): Int = ByteBuffer.wrap(this).int

fun ByteArray.toFloat(): Float = ByteBuffer.wrap(this).float

fun ByteArray.toDouble(): Double = ByteBuffer.wrap(this).double

fun ByteArray.copyWithLength(fromIndex: Int, length: Int) = copyOfRange(fromIndex, fromIndex + length)