package cl.admedios.searchml.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import cl.admedios.searchml.model.ResponseSearch
import cl.admedios.searchml.model.Result
import cl.admedios.searchml.network.RetrofitInstance
import cl.admedios.searchml.util.Constants
import cl.admedios.searchml.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var productList: MutableLiveData<Resource<ResponseSearch>> = MutableLiveData()
    var apiProductResponse: MutableList<Result>? = null

    fun makeApiCallListSearch(context: Context, search: String?="") =
        viewModelScope.launch {
            productList.postValue(Resource.Loading())
            val response =
                RetrofitInstance.api.getSearchList(Constants.SITE_ID, search.toString(), Constants.LIMIT)
            productList.postValue(handleProductListResponse(response))
        }

    private fun handleProductListResponse(response: Response<ResponseSearch>): Resource<ResponseSearch> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                if (apiProductResponse == null) {
                    apiProductResponse = resultResponse.results
                } else {
                        val oldArticles = apiProductResponse!!
                        val newArticles = resultResponse.results
                        if (!newArticles.isNullOrEmpty()) oldArticles.addAll(newArticles)
                }
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}