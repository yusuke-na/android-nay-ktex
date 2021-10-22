/*
 * Created by Naaatan on 2021/10/22 10:33
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/10/22 10:33
 */

package nay.lib.ktex

import java.math.BigDecimal

/**
 * Separate double into integer and decimal parts.
 *
 * @return [Pair.first] is Integer part. [Pair.second] is Decimal part.
 */
fun Double.separateInto(): Pair<Int, BigDecimal> {
    val bd = BigDecimal.valueOf(this)
    val intV = bd.toInt()
    val decV = bd.subtract(BigDecimal(intV))
    return intV to decV
}

/**
 * Move the decimal point to the left (10 ^ -[move])
 */
fun Double.movePointLeft(move: Int): BigDecimal =
    BigDecimal.valueOf(this).movePointLeft(move)

/**
 * Move the decimal point to the right (10 ^ [move])
 */
fun Double.movePointRight(move: Int): BigDecimal =
    BigDecimal.valueOf(this).movePointRight(move)