package com.example.kalavidarabalaga.data

import android.net.Uri

object ProfileData {

    var profileImage: Uri? = null

    var galleryImages: List<Uri> = emptyList()

    var name: String = ""

    var district: String = ""

    var experience: String = ""

    var specialization: String = ""

    var about: String = ""

    var isProfileSaved: Boolean = false
}