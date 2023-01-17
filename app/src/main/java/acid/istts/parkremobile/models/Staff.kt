package acid.istts.parkremobile.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Staff(
    var id: Int,
    var username: String,
    var name: String,
    var address: String,
    var password: String,
    var phone: String,
    var role_id: Int,
    var role_name: String?
) : Parcelable {
}