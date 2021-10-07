package cl.admedios.searchml.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.admedios.searchml.R
import cl.admedios.searchml.databinding.ActivityHomeBinding
import cl.admedios.searchml.ui.adapter.ListProductAdapter
import cl.admedios.searchml.util.DogListCallBack
import cl.admedios.searchml.util.Resource

class HomeActivity : AppCompatActivity(), DogListCallBack {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var recyclerView: RecyclerView
    var listDogAdapter: ListProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        var view = binding.root
        supportActionBar!!.hide()
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setInit()
        setInitSearch()
        setContentView(view)
    }

    private fun setInit() {
        supportActionBar?.setTitle(R.string.text_title_list)
        setupRecyclerView()
        setObserverList()
    }

    private fun setupRecyclerView() {
        listDogAdapter = ListProductAdapter(this, binding.root.context)
        binding.recyclerViewDogList.apply {
            adapter = listDogAdapter
            layoutManager = GridLayoutManager(binding.root.context, 1)
            isNestedScrollingEnabled = false
        }
        binding.recyclerViewDogList.addItemDecoration(
            DividerItemDecoration(
                binding.root.context,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    private fun setObserverList() {
        viewModel.productList.observe(this, { response ->
            when (response) {
                is Resource.Success -> {
                    showLoader(true)
                    response.data?.let { it ->
                        if (it.results.isNullOrEmpty()) {
                            showLoader(false)
                            return@let
                        } else if (!it.results.isNullOrEmpty()) {
                            listDogAdapter!!.differ.submitList(it.results.toList())
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


    private fun setInitSearch() {
        //binding.componentSearchResult.root.visibility = View.VISIBLE
        binding.appBarSearch.searchBoxId.onActionViewExpanded()
        binding.appBarSearch.searchBoxId.performClick()
        binding.appBarSearch.searchBoxId.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //queryName = query.toString()
                //loadResultData(query)
                //query?.let { searchSave(it) }
                viewModel.makeApiCallListSearch(binding.root.context, query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                /*queryName = newText.toString()
                loadResultData(newText)*/
                viewModel.makeApiCallListSearch(binding.root.context, newText)
                return false
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