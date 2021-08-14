package nay.lib.ktex.converter

import java.nio.ByteBuffer

fun ByteArray.toHex(): String = asUByteArray().joinToString {
    it.toString(radix = 16).padStart(2, '0')
}

fun ByteArray.toHexWithPrefix(): String = "0x%s".format(toHex())

fun ByteArray.toLong(): Long = ByteBuffer.wrap(this).long

fun ByteArray.toInt(): Int = ByteBuffer.wrap(this).int

fun ByteArray.toFloat(): Float = ByteBuffer.wrap(this).float

fun ByteArray.toDouble(): Double = ByteBuffer.wrap(this).double