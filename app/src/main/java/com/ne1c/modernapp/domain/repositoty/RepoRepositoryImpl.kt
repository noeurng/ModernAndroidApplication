package com.ne1c.modernapp.domain.repositoty

import com.ne1c.modernapp.data.network.model.RepositoryModel
import com.ne1c.modernapp.data.network.source.NetworkDataSource

class RepoRepositoryImpl(private val networkDataSource: NetworkDataSource): RepoRepository {
    override suspend fun getTopRepositories(): ArrayList<RepositoryModel> {
        return networkDataSource.getTopRepositories()
    }

    override suspend fun searchRepository(query: String): ArrayList<RepositoryModel> {
        return networkDataSource.searchRepositories(query)
    }
}