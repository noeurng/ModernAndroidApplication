package com.ne1c.modernapp.data.db.mapper

import com.ne1c.modernapp.data.db.model.LocalRepositoryModel
import com.ne1c.modernapp.data.network.model.OwnerRepositoryModel
import com.ne1c.modernapp.data.network.model.RepositoryModel

fun map(local: LocalRepositoryModel): RepositoryModel {
    return RepositoryModel()
            .apply {
                id = local.id
                name = local.name
                description = local.description
                language = local.language
                stars = local.stars
                forks = local.forks
                owner = OwnerRepositoryModel().apply {
                    this.id = local.ownerId
                    this.login = local.ownerName
                    this.avatarUrl = local.ownerAvatarUrl
                }
            }
}

fun map(remote: RepositoryModel): LocalRepositoryModel {
    return LocalRepositoryModel()
            .apply {
                id = remote.id
                name = remote.name
                description = remote.description
                language = remote.language ?: ""
                stars = remote.stars
                forks = remote.forks
                ownerId = remote.owner!!.id
                ownerName = remote.owner!!.login
                ownerAvatarUrl = remote.owner!!.avatarUrl
            }
}