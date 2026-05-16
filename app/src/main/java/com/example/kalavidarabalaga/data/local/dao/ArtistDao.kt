package com.example.kalavidarabalaga.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.kalavidarabalaga.data.local.entity.ArtistEntity

@Dao
interface ArtistDao {

    @Insert
    suspend fun insertArtist(
        artist: ArtistEntity
    )

    @Update
    suspend fun updateArtist(
        artist: ArtistEntity
    )

    @Delete
    suspend fun deleteArtist(
        artist: ArtistEntity
    )

    @Query("SELECT * FROM artists")
    fun getAllArtists():
            LiveData<List<ArtistEntity>>
}