package com.ne1c.modernapp.domain.repositoty

import com.ne1c.modernapp.data.network.model.RepositoryModel

interface RepoRepository {
    suspend fun getTopRepositories(): ArrayList<RepositoryModel>

    suspend fun searchRepository(query: String): ArrayList<RepositoryModel>
}