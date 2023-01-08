package acid.istts.parkremobile.services

import acid.istts.parkremobile.interfaces.UserDAO
import acid.istts.parkremobile.models.UserEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [
    UserEntity::class
], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract val userDao: UserDAO

    companion object {
        private var database: AppDatabase? = null

        fun build(context: Context?): AppDatabase {
            if (database == null) {
                database = Room.databaseBuilder(context!!, AppDatabase::class.java, "parkre_database").build()
            }
            return database!!
        }
    }
}