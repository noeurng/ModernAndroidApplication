package com.ne1c.modernapp.data.network.api

import com.ne1c.modernapp.data.network.response.SearchRepositoryResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface GithubApi {
    @GET("/search/repositories?q=topic:android")
    fun getTopRepositories(): Deferred<SearchRepositoryResponse>
}