package de.bitknight.kotlinlearning

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by dsemprich on 25.09.17.
 */
class MainViewModel : ViewModel() {
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories(){
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback{
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}