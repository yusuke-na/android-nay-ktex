/*
 * Created by Naaatan on 2022/06/04 21:45
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2022/06/04 21:45
 */

package nay.lib.ktex.util

/**
 * [p1]がNullではない場合、[f]を実行
 */
inline fun <T> ensureNotNull(p1: T?, f: (p1: T) -> Unit) {
    if (p1 != null) f(p1)
}

/**
 * [p1], [p2]がNullではない場合、[f]を実行
 */
inline fun <T1, T2> ensureNotNull(p1: T1?, p2: T2?, f: (p1: T1, p2: T2) -> Unit) {
    if (p1 != null && p2 != null) f(p1, p2)
}

/**
 * [p1], [p2], [p3]がNullではない場合、[f]を実行
 */
inline fun <T1, T2, T3> ensureNotNull(p1: T1?, p2: T2?, p3: T3?, f: (p1: T1, p2: T2, p3: T3) -> Unit) {
    if (p1 != null && p2 != null && p3 != null) f(p1, p2, p3)
}

/**
 * [t1], [t2]がNullではない場合、SafeCastをしてオブジェクトを返す
 */
fun <T1, T2> safe(t1: T1?, t2: T2?): Pair<T1, T2>? {
    return if (t1 == null || t2 == null) null else Pair(t1, t2)
}

/**
 * [t1], [t2], [t3]がNullではない場合、SafeCastをしてオブジェクトを返す
 */
fun <T1, T2, T3> safe(t1: T1?, t2: T2?, t3: T3?): Triple<T1, T2, T3>? {
    return if (t1 == null || t2 == null || t3 == null) null else Triple(t1, t2, t3)
}
