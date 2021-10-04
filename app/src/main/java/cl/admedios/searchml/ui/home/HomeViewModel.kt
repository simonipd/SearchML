package cl.admedios.searchml.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.admedios.searchml.model.DogAPIResponse
import cl.admedios.searchml.network.RetrofitInstance
import cl.admedios.searchml.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var dogList: MutableLiveData<Resource<DogAPIResponse>> = MutableLiveData()
    var apiDogResponse: DogAPIResponse? = null

    fun makeApiCallListDog(context: Context) =
        viewModelScope.launch {
            dogList.postValue(Resource.Loading())
            val response =
                RetrofitInstance.api.getDogList()
            dogList.postValue(handleProductListResponse(response))
        }

    private fun handleProductListResponse(response: Response<DogAPIResponse>): Resource<DogAPIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                if (apiDogResponse == null) {
                    apiDogResponse = resultResponse
                } else {
                        val oldArticles = apiDogResponse!!.message
                        val newArticles = resultResponse.message
                        if (!newArticles.isNullOrEmpty()) oldArticles!!.addAll(newArticles)
                }
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}