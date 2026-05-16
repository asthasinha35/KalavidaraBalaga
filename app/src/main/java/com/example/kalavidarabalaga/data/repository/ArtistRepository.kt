package com.example.kalavidarabalaga.data.repository

import com.example.kalavidarabalaga.data.local.dao.ArtistDao
import com.example.kalavidarabalaga.data.local.entity.ArtistEntity

class ArtistRepository(
    private val artistDao: ArtistDao
) {

    val allArtists =
        artistDao.getAllArtists()

    suspend fun insertArtist(
        artist: ArtistEntity
    ) {

        artistDao.insertArtist(artist)
    }
}