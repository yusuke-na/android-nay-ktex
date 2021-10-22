/*
 * Created by Naaatan on 2021/09/04 17:52
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:52
 */

package nay.lib.ktex

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import java.io.File

fun Uri.getName(context: Context): String? {
    return when (scheme) {
        "content" -> {
            val projection = listOf(MediaStore.MediaColumns.DISPLAY_NAME).toTypedArray()
            return context.contentResolver.query(this, projection, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME))
                } else null
            }
        }
        "file" -> {
            path?.let { File(it).name }
        }
        else -> null
    }
}