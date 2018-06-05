package com.ne1c.modernapp.data.network.model

import com.google.gson.annotations.SerializedName

class RepositoryModel {
    var id: Int = 0
    var name: String = ""
    var desciption: String = ""
    var language: String = ""
    var owner: RepositoryModel? = null

    @SerializedName("stargazers_count")
    var start = 0

    @SerializedName("watchers_count")
    var watchers = 0
}