package de.bitknight.kotlinlearning.main.data

import android.os.Handler

/**
 * Created by dsemprich on 26.09.17.
 */
class GitRepoRemoteDataSource {

    fun getRepositories(onRepositoryReadyCallback: OnRepoRemoteReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First From Local", "Owner 1", 100, false))
        arrayList.add(Repository("Second From Local", "Owner 2", 30, true))
        arrayList.add(Repository("Third From Local", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onRemoteDataReady(arrayList) }, 2000)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>){
        //todo save repositories in DB
    }
}

interface OnRepoRemoteReadyCallback {
    fun onRemoteDataReady(data: ArrayList<Repository>)
}