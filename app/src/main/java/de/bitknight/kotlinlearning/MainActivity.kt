package de.bitknight.kotlinlearning

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import de.bitknight.kotlinlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener  {

    private lateinit var binding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)

    var repository = Repository("Medium Android de.bitknight.kotlinlearning.Repository Article",
            "Fleka", 1000, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this,
                Observer<ArrayList<Repository>> { it?.let{ repositoryRecyclerViewAdapter.replaceData(it)} })

    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


