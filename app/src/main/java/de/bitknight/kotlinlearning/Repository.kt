package de.bitknight.kotlinlearning

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Created by dsemprich on 25.09.17.
 */
class Repository(repositoryName : String, var repositoryOwner: String?, var numberOfStars: Int?
                 , var hasIssues: Boolean = false) : BaseObservable(){

    @get:Bindable
    var repositoryName : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.repositoryName)
        }

}