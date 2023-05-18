package com.fjavmv.viewbindingdbroom.db



import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjavmv.viewbindingdbroom.db.dao.UserDao
import com.fjavmv.viewbindingdbroom.entidad.User

//::crea una referencia de miembro o una referencia de clase .

@Database(entities = [User:: class], version = 1)
abstract class AppDatabase : RoomDatabase(){
   abstract fun userDao(): UserDao


 /*  companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }*/
}