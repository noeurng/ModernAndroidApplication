package com.ne1c.modernapp.data.network.api

import com.ne1c.modernapp.data.network.model.RepositoryModel
import com.ne1c.modernapp.data.network.response.SearchRepositoryResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("/search/repositories")
    fun searchRepositories(@Query("q") query: String): Deferred<SearchRepositoryResponse>

    @GET("/repositories")
    fun getTopRepositories(): Deferred<ArrayList<RepositoryModel>>
}