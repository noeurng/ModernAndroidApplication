package com.ne1c.modernapp.domain.repositoty

import com.ne1c.modernapp.data.db.mapper.map
import com.ne1c.modernapp.data.db.source.DatabaseSource
import com.ne1c.modernapp.data.network.model.RepositoryModel
import com.ne1c.modernapp.data.network.source.NetworkDataSource
import com.ne1c.modernapp.domain.NetworkState

class RepoRepositoryImpl(private val networkDataSource: NetworkDataSource,
                         private val databaseSource: DatabaseSource,
                         private val networkState: NetworkState) : RepoRepository {
    override suspend fun getTopRepositories(): ArrayList<RepositoryModel> {
        return if (networkState.isConnected()) {
            val remoteData = networkDataSource.getTopRepositories()
            val localData = remoteData.map { map(it) }

            databaseSource.repositoryDao().insertAll(*localData.toTypedArray())

            return remoteData
        } else {
            val localData = databaseSource.repositoryDao().getAll()
            localData.map { map(it) } as ArrayList<RepositoryModel>
        }
    }
}