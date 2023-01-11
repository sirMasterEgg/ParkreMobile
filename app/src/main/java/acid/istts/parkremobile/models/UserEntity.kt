package acid.istts.parkremobile.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: Int? = null,
    val db_id: Int? = null,
    val token: String? = null,
    val role: Int? = null, // 1 = customer, 2 = admin, 3 = staff
)