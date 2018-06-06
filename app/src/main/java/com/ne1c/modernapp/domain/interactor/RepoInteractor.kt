package com.ne1c.modernapp.domain.interactor

import com.ne1c.modernapp.data.network.model.RepositoryModel
import com.ne1c.modernapp.domain.repositoty.RepoRepository

class RepoInteractor(private val repoRepository: RepoRepository) {
    suspend fun getTopRepositories(): ArrayList<RepositoryModel> {
        return repoRepository.getTopRepositories()
    }
}