package com.example.kalavidarabalaga.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "troupes")

data class TroupeEntity(

    @PrimaryKey(autoGenerate = true)

    val id: Int = 0,

    val name: String,

    val artForm: String,

    val district: String,

    val imageUri: String,

    val leaderName: String,

    val contact: String,

    val about: String
)