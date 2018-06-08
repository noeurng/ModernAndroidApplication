package com.ne1c.modernapp.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class LocalRepositoryModel {
    @PrimaryKey
    var id = 0L
    var name = ""
    var description = ""
    var language = ""
    var stars = 0
    var forks = 0

    // Owner
    var ownerId = 0L
    var ownerName = ""
    var ownerAvatarUrl = ""
}