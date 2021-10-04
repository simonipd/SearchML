package cl.admedios.searchml.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.admedios.searchml.R
import cl.admedios.searchml.databinding.ActivityHomeBinding
import cl.admedios.searchml.ui.adapter.ListDogAdapter
import cl.admedios.searchml.util.DogListCallBack
import cl.admedios.searchml.util.Resource

class HomeActivity : AppCompatActivity(), DogListCallBack {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var recyclerView: RecyclerView
    var listDogAdapter: ListDogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        var view = binding.root
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setInit()
        setContentView(view)
    }

    private fun setInit() {
        supportActionBar?.setTitle(R.string.text_title_list)
        setupRecyclerView()
        setObserverList()
        viewModel.makeApiCallListDog(this)
    }

    private fun setupRecyclerView() {
        listDogAdapter = ListDogAdapter(this, binding.root.context)
        binding.recyclerViewDogList.apply {
            adapter = listDogAdapter
            layoutManager = GridLayoutManager(binding.root.context, 2)
            isNestedScrollingEnabled = false
        }
    }

    private fun setObserverList() {
        viewModel.dogList.observe(this, { response ->
            when (response) {
                is Resource.Success -> {
                    showLoader(true)
                    response.data?.let { it ->
                        if (it.message.isNullOrEmpty()) {
                            showLoader(false)
                            return@let
                        } else if (!it.message.isNullOrEmpty()) {
                            listDogAdapter!!.differ.submitList(it.message.toList())
                            showLoader(false)
                        }
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        showLoader(false)
                    }
                }
                is Resource.Loading -> {
                    showLoader(false)
                }
            }
        })
    }

    private fun showLoader(b: Boolean) {
       if (b){
           binding.progressBar.root.visibility = View.VISIBLE
       }else{
           binding.progressBar.root.visibility = View.GONE
       }
    }
}