package acid.istts.parkremobile.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Reservation(
    var id: Int,
    var start_time: String,
    var end_time: String,
    var price: Int,
    var status: Int,
    var date: String,
    var user_id: Int,
    var vehicle_id: Int,
    var segmentation_id: Int,
    var user_name: String,
    var vehicle_plate: String,
    var segmentation_name: String,
    var mall_name: String
) : Parcelable {
}