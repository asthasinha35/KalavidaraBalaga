package com.example.kalavidarabalaga.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import kotlinx.coroutines.flow.Flow

@Dao
interface TroupeDao {

    @Insert
    suspend fun insertTroupe(

        troupe: TroupeEntity
    )

    @Delete
    suspend fun deleteTroupe(

        troupe: TroupeEntity
    )

    @Query("SELECT * FROM troupes")

    fun getAllTroupes():

            Flow<List<TroupeEntity>>
}