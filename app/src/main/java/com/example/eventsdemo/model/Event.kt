import android.os.Parcelable
import com.example.eventsdemo.response.*
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(


    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Image>,

    @SerializedName("locale")
    val locale: String,
    @SerializedName("name")
    val name: String,


    @SerializedName("test")
    val test: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
):Parcelable