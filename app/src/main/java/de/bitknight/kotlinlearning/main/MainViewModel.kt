package de.bitknight.kotlinlearning.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import de.bitknight.kotlinlearning.main.data.GitRepoRepository
import de.bitknight.kotlinlearning.main.data.OnRepositoryReadyCallback
import de.bitknight.kotlinlearning.main.data.Repository
import de.bitknight.kotlinlearning.util.NetManager

/**
 * Created by dsemprich on 25.09.17.
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetManager(getApplication()))
    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories(){
        isLoading.set(true)
        gitRepoRepository.getGitRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}