package acid.istts.parkremobile.models

class Transaction (
    var id: Int,
    var price: Int,
    var date: String? = null,
    var user_id: Int? = null,
    var reservation_id: Int? = null,
    var user_name: String? = null,
    var reservation_start_time: String? = null,
    var reservation_end_time: String? = null,
    var reservation_price: Int? = null,
    var mall_id: Int? = null,
    var mall_name: String? = null,
    var vehicle_id: Int? = null,
    var vehicle_plate: String? = null,
){
}