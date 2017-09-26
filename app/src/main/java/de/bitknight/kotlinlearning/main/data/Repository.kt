package de.bitknight.kotlinlearning.main.data

import android.databinding.BaseObservable
import android.databinding.Bindable
import de.bitknight.kotlinlearning.BR

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