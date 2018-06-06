package com.ne1c.modernapp.data.network.model

import com.google.gson.annotations.SerializedName

class RepositoryModel {
    var id = 0L
    var name = ""
    var description = ""
    var language = ""
    var owner: OwnerRepositoryModel? = null

    @SerializedName("stargazers_count")
    var stars = 0

    @SerializedName("forks_count")
    var forks = 0
}