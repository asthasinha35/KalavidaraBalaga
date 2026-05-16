package com.example.kalavidarabalaga.data

class TroupeRepository(

    private val troupeDao: TroupeDao
) {

    val allTroupes =

        troupeDao.getAllTroupes()

    suspend fun insertTroupe(

        troupe: TroupeEntity
    ) {

        troupeDao.insertTroupe(troupe)
    }

    suspend fun deleteTroupe(

        troupe: TroupeEntity
    ) {

        troupeDao.deleteTroupe(troupe)
    }
}