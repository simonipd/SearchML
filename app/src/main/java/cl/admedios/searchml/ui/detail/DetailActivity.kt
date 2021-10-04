package cl.admedios.searchml.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.admedios.searchml.R
import cl.admedios.searchml.databinding.ActivityDetailBinding
import cl.admedios.searchml.ui.adapter.ListImagenDogAdapter
import cl.admedios.searchml.util.Constants
import cl.admedios.searchml.util.DogListCallBack

class DetailActivity : AppCompatActivity(), DogListCallBack {
    lateinit var binding: ActivityDetailBinding
    lateinit var viewModel: DetailViewModel
    lateinit var recyclerView: RecyclerView
    var listImageDogAdapter: ListImagenDogAdapter? = null
    var dogName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        var view = binding.root
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setInit()
        setContentView(view)
    }

    private fun setInit() {
        dogName = intent.getStringExtra(Constants.DOG_NAME) ?: ""
        supportActionBar?.setTitle(R.string.text_title_detail)
        setupRecyclerView()
        setObserverList()
        setCall()
    }

    private fun setCall() {
        if (dogName != null) viewModel.makeApiCallGetDogImageList(this, dogName!!)
    }

    private fun setupRecyclerView() {
        listImageDogAdapter = ListImagenDogAdapter(this, binding.root.context)
        binding.recyclerViewImagenList.apply {
            adapter = listImageDogAdapter
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.HORIZONTAL,
                false
            )
            isNestedScrollingEnabled = false
        }
    }

    private fun setObserverList() {
        viewModel.getDogListDataObserver().observe(this, Observer {
            listImageDogAdapter!!.differ.submitList(it.message.toList())
            binding.tvName.text = dogName!!.toUpperCase()
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}