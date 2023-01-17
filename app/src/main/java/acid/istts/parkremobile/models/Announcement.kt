package acid.istts.parkremobile.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Announcement(
    var id: Int,
    var header: String,
    var content: String,
    var status: Int,
    var mall_id: Int,
    var staff_id: Int,
    var mall_name: String,
    var created_at: String? = null
): Parcelable {

}