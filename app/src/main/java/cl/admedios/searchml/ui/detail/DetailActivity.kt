package cl.admedios.searchml.ui.detail

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import cl.admedios.searchml.R
import cl.admedios.searchml.databinding.ActivityDetailBinding
import cl.admedios.searchml.model.ResultData
import cl.admedios.searchml.util.AppLogger
import cl.admedios.searchml.util.Constants
import cl.admedios.searchml.util.ProductListCallBack
import cl.admedios.searchml.util.FunctionsUtils
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), ProductListCallBack {
    lateinit var binding: ActivityDetailBinding
    lateinit var viewModel: DetailViewModel
    var productName: ResultData? = null

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
        productName = intent.getParcelableExtra(Constants.PRODUCT_NAME) as ResultData?
        AppLogger.i("bundle", "bundle -->" + productName)
        supportActionBar?.setTitle(R.string.text_title_detail)
        viewModel.result = productName
        setObserverData()
    }

    private fun setObserverData() {
        binding.tvStatus.text = if (viewModel.result!!.condition.equals("new")) "Nuevo" else "Usado"
        binding.tvName.text = viewModel.result!!.title
        binding.tvBrand.text = viewModel.result!!.attributes[0].valueName
        binding.tvPrice.text =
            "$ ${FunctionsUtils.numberFormatLong(viewModel.result!!.price.toLong())}"
        if (viewModel.result!!.originalPrice.toInt() == 0) {
            binding.tvLastprice.visibility = View.GONE
        } else {
            binding.tvLastprice.text =
                "$ ${FunctionsUtils.numberFormatLong(viewModel.result!!.originalPrice).toString()}"
            binding.tvLastprice.paintFlags =
                binding.tvLastprice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG
        }
        Glide.with(this)
            .load(viewModel.result!!.thumbnail)
            .placeholder(R.drawable.default_thumb)
            .error(R.drawable.default_thumb)
            .fallback(R.drawable.default_thumb)
            .into(binding.imgProduct)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}