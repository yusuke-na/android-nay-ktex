/*
 * Created by Naaatan on 2021/09/04 17:45
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:45
 */

package nay.lib.ktex

import java.math.BigDecimal

fun Short.toByteArray() = byteArrayOf(0x00, 0x00).let {
    it[0] = ((this.toInt() and 0xFF00 shr 8).toByte())
    it[1] = (this.toInt() and 0x00FF).toByte()
    it
}