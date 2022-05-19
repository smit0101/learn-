import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageData(val success:Boolean, val data:Data)

@Serializable
data class Memes(val id:Int, val name:String?, val url:String, val width:Int, val height:Int, @SerialName("box_count") val boxCount:Int)

@Serializable
data class Data(val memes:MutableList<Memes>)