/*
 * Created by Naaatan on 2021/10/22 11:29
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/10/22 11:28
 */

package nay.lib.ktex.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object TimerUtil {

    /**
     * Format timeInMillis to 'HH:mm:ss' or 'HH:mm:ss.SSS'.
     *
     * When [includeMillis] is True, 'HH:mm:ss' is returned and 'HH:mm:ss.SSS' is returned for False.
     */
    fun formattedTime(timeInMillis: Long, includeMillis: Boolean): String {
        var milliseconds = timeInMillis
        val hours = TimeUnit.MILLISECONDS.toHours(milliseconds)
        milliseconds -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
        milliseconds -= TimeUnit.MINUTES.toMillis(minutes)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
        if (!includeMillis) {
            return "$hours".padStart(1, '0') + ":" +
                    "$minutes".padStart(2, '0') + ":" +
                    "$seconds".padStart(2, '0')
        }
        milliseconds -= TimeUnit.SECONDS.toMillis(seconds)
        // milliseconds /= 10
        return "$hours".padStart(1, '0') + ":" +
                "$minutes".padStart(2, '0') + ":" +
                "$seconds".padStart(2, '0') + "." +
                "$milliseconds".padStart(3, '0')
    }

    /**
     * Format timeInMillis to [format].
     *
     * default format is 'yyyy-MM-dd_HH-mm-ss-SSS'.
     */
    fun formattedTime(timeInMillis: Long, format: String = "yyyy-MM-dd_HH-mm-ss-SSS"): String {
        val sdf = SimpleDateFormat(format, Locale.US)
        val result = runCatching { sdf.format(timeInMillis) }
        return when {
            result.isFailure -> timeInMillis.toString()
            result.isSuccess -> result.getOrNull()!!
            else -> timeInMillis.toString()
        }
    }

}