package com.ne1c.modernapp.data.network.source

import com.ne1c.modernapp.data.network.api.GithubApi
import com.ne1c.modernapp.data.network.model.RepositoryModel

class NetworkDataSource(private val githubApi: GithubApi) {
    suspend fun getTopRepositories(): ArrayList<RepositoryModel> {
        return githubApi.getTopRepositories().await().items
    }
}