package acid.istts.parkremobile.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Customer(
    // customer attributes that will be fetched from the database
    var id : Int = 0,
    var name : String = "",
    var password : String = "",
    var email : String = "",
    var phone : String = "",
    var address : String = "",
    var token: String = "",
    var image_url: String? = null
) : Parcelable {
}