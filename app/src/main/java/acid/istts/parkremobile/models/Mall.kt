package acid.istts.parkremobile.models

class Mall(
    var id: Int,
    var name: String,
    var slug: String,
    var address: String,
    var park_space: Int,
    var reserve_space: Int,
    var available_space: Int,
    var image_url: String
) {
}