package acid.istts.parkremobile.models

class Transaction (
    var id: Int,
    var price: Int,
    var date: String,
    var user_id: Int,
    var reservation_id: Int,
    var user_name: String,
    var reservation_start_time: String,
    var reservation_end_time: String,
    var reservation_price: Int,
    var mall_id: Int,
    var mall_name: String,
    var vehicle_id: Int,
    var vehicle_plate: String,
){
}