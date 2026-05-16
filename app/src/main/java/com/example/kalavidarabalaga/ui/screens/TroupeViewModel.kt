package com.example.kalavidarabalaga.ui.screens

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope

import com.example.kalavidarabalaga.data.AppDatabase
import com.example.kalavidarabalaga.data.TroupeEntity

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TroupeViewModel(

    application: Application

) : AndroidViewModel(application) {

    private val troupeDao =
        AppDatabase
            .getDatabase(application)
            .troupeDao()

    val troupeList: Flow<List<TroupeEntity>> =
        troupeDao.getAllTroupes()

    fun insertTroupe(

        troupe: TroupeEntity
    ) {

        viewModelScope.launch {

            troupeDao.insertTroupe(
                troupe
            )
        }
    }

    fun deleteTroupe(

        troupe: TroupeEntity
    ) {

        viewModelScope.launch {

            troupeDao.deleteTroupe(
                troupe
            )
        }
    }
}