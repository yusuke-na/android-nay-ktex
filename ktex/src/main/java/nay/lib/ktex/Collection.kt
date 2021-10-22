/*
 * Created by Naaatan on 2021/09/04 17:47
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:47
 */

package nay.lib.ktex

fun <E> List<E>.divide(size: Int): List<List<E>> {
    if (isEmpty() || size <= 0) {
        return mutableListOf()
    }

    val block = this.size / size + (if (this.size % size > 0)  1 else 0)

    val ret : MutableList<List<E>> = mutableListOf()
    for (i in 0 until block) {
        val start = i * size
        val end = (start + size).coerceAtMost(this.size)
        val subList = this.subList(start, end)
        ret.add(subList)
    }
    return ret
}