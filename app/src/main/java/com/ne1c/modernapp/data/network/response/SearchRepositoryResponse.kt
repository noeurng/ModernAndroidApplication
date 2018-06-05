package com.ne1c.modernapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.ne1c.modernapp.data.network.model.RepositoryModel

class SearchRepositoryResponse {
    @SerializedName("total_count")
    var count = 0

    @SerializedName("incomplete_results")
    var incompleteResults = false

    var items = arrayListOf<RepositoryModel>()
}