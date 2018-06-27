package com.ne1c.modernapp.domain.repositoty

import com.ne1c.modernapp.data.db.mapper.map
import com.ne1c.modernapp.data.db.source.DatabaseSource
import com.ne1c.modernapp.data.network.model.RepositoryModel
import com.ne1c.modernapp.data.network.source.NetworkDataSource
import com.ne1c.modernapp.domain.NetworkState
import kotlinx.coroutines.experimental.async

class RepoRepositoryImpl(private val networkDataSource: NetworkDataSource,
                         private val databaseSource: DatabaseSource,
                         private val networkState: NetworkState) : RepoRepository {
    override suspend fun getTopRepositories(): ArrayList<RepositoryModel> {
        return if (networkState.isConnected()) {
            val remoteData = networkDataSource.getTopRepositories()
            val localData = remoteData.map { map(it) }

            async {
                databaseSource.repositoryDao().insertAll(*localData.toTypedArray())
            }.await()

            remoteData
        } else {
            val localData = async {
                databaseSource.repositoryDao().getAll()
            }.await()

            localData.map { map(it) } as ArrayList<RepositoryModel>
        }
    }
}