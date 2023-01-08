package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.UserEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user: UserEntity)

    @Query("SELECT token FROM user WHERE id = :id")
    suspend fun getToken(id: Int): String

    @Query("SELECT role FROM user WHERE id = :id")
    suspend fun getRole(id: Int): Int

    @Query("UPDATE user SET token = :token, role = :role WHERE id = :id")
    suspend fun setValues(id: Int, token: String, role: Int): Boolean

    @Query("UPDATE user SET token = null, role = null WHERE id = :id")
    suspend fun clear(id: Int): Boolean
}