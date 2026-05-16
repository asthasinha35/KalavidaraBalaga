package com.example.kalavidarabalaga.data

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(

    entities = [TroupeEntity::class],

    version = 3,

    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun troupeDao():
            TroupeDao

    companion object {

        @Volatile

        private var INSTANCE:
                AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance =
                    Room.databaseBuilder(

                        context.applicationContext,

                        AppDatabase::class.java,

                        "kalavidara_database"
                    )

                        .fallbackToDestructiveMigration()

                        .build()

                INSTANCE = instance

                instance
            }
        }
    }
}