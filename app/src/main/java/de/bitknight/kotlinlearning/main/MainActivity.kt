package de.bitknight.kotlinlearning.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import de.bitknight.kotlinlearning.R
import de.bitknight.kotlinlearning.databinding.ActivityMainBinding
import de.bitknight.kotlinlearning.main.adapter.RepositoryRecyclerViewAdapter
import de.bitknight.kotlinlearning.main.data.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)

    var repository = Repository("Medium Android de.bitknight.kotlinlearning.main.data.Repository Article",
            "Fleka", 1000, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        repository_rv.layoutManager = LinearLayoutManager(this)
        repository_rv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this,
                Observer<ArrayList<Repository>> { it?.let{
                    repository_rv.scheduleLayoutAnimation()
                    repositoryRecyclerViewAdapter.replaceData(it)
                } })

    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


