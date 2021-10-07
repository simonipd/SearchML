package cl.admedios.searchml.ui.detail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.smu.unimarcapp.data.netwok.api.RetroInstance
import cl.smu.unimarcapp.data.netwok.api.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
class DetailViewModel : ViewModel() {

    var dogImageList: MutableLiveData<DogAPIResponse> = MutableLiveData()

    fun getDogListDataObserver(): MutableLiveData<DogAPIResponse> {
        return dogImageList
    }

    fun makeApiCallGetDogImageList(context: Context, breedName: String) {
        val retroInstance = RetroInstance.getRetroInstance().create(
            RetroService::class.java
        )
        val call = retroInstance.getDogImages(breedName)
        callBack(call)
    }

    private fun callBack(call: Call<DogAPIResponse>) {
        call.enqueue(object : Callback<DogAPIResponse> {
            override fun onResponse(
                call: Call<DogAPIResponse>,
                response: Response<DogAPIResponse>
            ) {
                if (response.isSuccessful) {
                    val destination = response.body()
                    destination?.let {
                        dogImageList.postValue(response.body()!!)
                    }
                } else {
                    dogImageList.postValue(null)
                }
            }

            override fun onFailure(call: Call<DogAPIResponse>, t: Throwable) {
                t.printStackTrace()
                dogImageList.postValue(null)
            }
        })
    }
}*/
