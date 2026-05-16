package com.example.kalavidarabalaga.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")

data class ArtistEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,

    val artForm: String,

    val district: String,

    val phone: String,

    val bio: String,

    val imageUrl: String
)