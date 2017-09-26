package de.bitknight.kotlinlearning.main.data

import de.bitknight.kotlinlearning.util.NetManager

/**
 * Created by dsemprich on 25.09.17.
 */
class GitRepoRepository (val netManager: NetManager) {

    private val localDataSource = GitRepoLocalDataSource()
    private val remoteDataSource = GitRepoRemoteDataSource()

    fun getGitRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {

        netManager.isConnectedToInternet?.let {
            if (it) {
                remoteDataSource.getRepositories(object : OnRepoRemoteReadyCallback {
                    override fun onRemoteDataReady(data: ArrayList<Repository>) {
                        localDataSource.saveRepositories(data)
                        onRepositoryReadyCallback.onDataReady(data)
                    }
                })
            } else {
                localDataSource.getRepositories(object : OnRepoLocalReadyCallback {
                    override fun onLocalDataReady(data: ArrayList<Repository>) {
                        onRepositoryReadyCallback.onDataReady(data)
                    }
                })
            }
        }
    }
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data : ArrayList<Repository>)
}