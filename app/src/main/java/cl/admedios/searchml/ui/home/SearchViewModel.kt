package cl.admedios.searchml.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.admedios.searchml.util.AppLogger
import cl.smu.unimarcapp.data.netwok.api.RetroInstance
import cl.smu.unimarcapp.data.netwok.api.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchViewModel : ViewModel() {

/*    var recyclerSearchList: MutableLiveData<List<SearchData>> = MutableLiveData()

    init {
        recyclerSearchList = MutableLiveData()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<List<SearchData>> {
        return recyclerSearchList
    }


    fun makeApiCallGetSearch(search: String) {
        val retroInstance = RetroInstance.getRetroInstance().create(
            RetroService::class.java
        )

        val call = retroInstance.getDataFromAPISearch(
            search
        )

        call.enqueue(object : Callback<ApiSearchResponse> {
            override fun onResponse(
                call: Call<ApiSearchResponse>,
                response: Response<ApiSearchResponse>
            ) {
                if (response.isSuccessful) {
                    val destination = response.body()
                    destination?.let {
                        recyclerSearchList.postValue(response.body()!!.payload.data.searches)
                        AppLogger.i("URL --- Search", response.body()!!.toString())
                    }
                } else {
                    recyclerSearchList.postValue(null)
                }
            }

            override fun onFailure(call: Call<ApiSearchResponse>, t: Throwable) {
                t.printStackTrace()
                recyclerSearchList.postValue(null)
            }
        })
    }*/

}