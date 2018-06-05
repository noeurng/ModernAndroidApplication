package com.ne1c.modernapp.data.network.model

import com.google.gson.annotations.SerializedName

class OwnerRepositoryModel {
    var id = 0
    var login = ""

    @SerializedName("avatar_url")
    var avatarUrl = ""
}