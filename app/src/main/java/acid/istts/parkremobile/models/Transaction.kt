package acid.istts.parkremobile.models

class Transaction (
    var id: Int,
    var price: Int,
    var date: String,
    var user_id: Int,
    var reservation_id: Int,
){
}