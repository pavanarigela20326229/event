package com.example.eventsdemo.response
import Event
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class EventResponse(
    @SerializedName("_embedded")
    val embedded: Embedded,

    @SerializedName("page")
    val page: Page
)

data class Embedded(
    @SerializedName("events")
    val events: MutableList<Event>
)



data class Page(
    @SerializedName("number")
    val number: Int,
    @SerializedName("size")
    val size: Int,
    @SerializedName("totalElements")
    val totalElements: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)






@Parcelize
data class Image(
    @SerializedName("fallback")
    val fallback: Boolean,
    @SerializedName("height")
    val height: Int,
    @SerializedName("ratio")
    val ratio: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
):Parcelable
























data class Public(
    @SerializedName("endDateTime")
    val endDateTime: String,
    @SerializedName("startDateTime")
    val startDateTime: String,
    @SerializedName("startTBA")
    val startTBA: Boolean,
    @SerializedName("startTBD")
    val startTBD: Boolean
)

