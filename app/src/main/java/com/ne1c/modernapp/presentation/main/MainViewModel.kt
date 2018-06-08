package com.ne1c.modernapp.presentation.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ne1c.modernapp.data.network.model.RepositoryModel
import com.ne1c.modernapp.domain.interactor.RepoInteractor
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainViewModel(private val repoInteractor: RepoInteractor) : ViewModel() {
    val topRepositories = MutableLiveData<ArrayList<RepositoryModel>>()
    val loadingState = MutableLiveData<Boolean>()

    fun start() {
        loadingState.value = true

        launch(UI) {
            topRepositories.value = repoInteractor.getTopRepositories()
            loadingState.value = false
        }
    }

}