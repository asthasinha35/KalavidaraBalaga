package com.example.kalavidarabalaga.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import com.example.kalavidarabalaga.data.local.database.AppDatabase
import com.example.kalavidarabalaga.data.local.entity.ArtistEntity
import com.example.kalavidarabalaga.data.repository.ArtistRepository

import kotlinx.coroutines.launch

class ArtistViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository: ArtistRepository

    val allArtists:
            LiveData<List<ArtistEntity>>

    init {

        val dao =
            AppDatabase
                .getDatabase(application)
                .artistDao()

        repository =
            ArtistRepository(dao)

        allArtists =
            repository.allArtists
    }

    fun insertArtist(
        artist: ArtistEntity
    ) {

        viewModelScope.launch {

            repository.insertArtist(artist)
        }
    }
}