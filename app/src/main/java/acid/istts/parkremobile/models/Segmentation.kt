package acid.istts.parkremobile.models

class Segmentation (
    var id: Int,
    var name: String,
    var slug: String,
    var park_space: Int,
    var reserve_space: Int,
    var initial_price: Int,
    var price: Int,
    var mall_id: Int,
    var image_url: String,
    var mall_name: String
) {
}