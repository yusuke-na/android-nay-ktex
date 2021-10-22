/*
 * Created by Naaatan on 2021/10/22 10:43
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/10/22 10:43
 */

package nay.lib.ktex

import java.math.BigDecimal

/**
 * separate float into integer and decimal parts.
 *
 * @return [Pair.first] is Integer part. [Pair.second] is Decimal part.
 */
fun Float.separateInto(): Pair<Int, BigDecimal> {
    val bd = this.toBigDecimal()
    val intV = bd.toInt()
    val decV = bd.subtract(BigDecimal(intV))
    return intV to decV
}

/**
 * Move the decimal point to the left (10 ^ -[move])
 */
fun Float.movePointLeft(move: Int): BigDecimal =
    this.toBigDecimal().movePointLeft(move)

/**
 * Move the decimal point to the right (10 ^ [move])
 */
fun Float.movePointRight(move: Int): BigDecimal =
    this.toBigDecimal().movePointRight(move)