package com.example.kalavidarabalaga.data.local.database

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.kalavidarabalaga.data.local.dao.ArtistDao
import com.example.kalavidarabalaga.data.local.entity.ArtistEntity

@Database(
    entities = [ArtistEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun artistDao(): ArtistDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "kalavidara_database"
                    ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}