package acid.istts.parkremobile.interfaces

import acid.istts.parkremobile.models.UserEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user: UserEntity)

    @Query("SELECT COUNT(*) FROM user")
    suspend fun getCount(): Int

    @Query("SELECT db_id FROM user WHERE id = 1")
    suspend fun getDBId(): Int?

    @Query("SELECT token FROM user WHERE id = 1")
    suspend fun getToken(): String?

    @Query("SELECT role FROM user WHERE id = 1")
    suspend fun getRole(): Int?

    @Query("UPDATE user SET db_id = :db_id, token = :token, role = :role WHERE id = 1")
    suspend fun setValues(db_id: Int, token: String, role: Int): Int

    @Query("UPDATE user SET token = null, role = null WHERE 1")
    suspend fun clear(): Int
}