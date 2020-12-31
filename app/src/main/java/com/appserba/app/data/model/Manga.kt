package com.appserba.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga(
    val title: String = "",
    val thumb: String = "",
    val type: String = "",
    val updated_on: String = "",
    val endpoint: String = "",
    val chapter: String = ""
) : Parcelable
