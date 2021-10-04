package cl.smu.unimarcapp.data.netwok.api

import cl.admedios.searchml.model.DogAPIResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetroService {
    /*  New Services  */
    //*** Dog get list ***//
    @GET("breeds/list")
    suspend fun getDogList(): Response<DogAPIResponse>

    //*** Dog *** get images ***//
    @GET("breed/{breedName}/images")
    fun getDogImages(
            @Path("breedName") breedName: String
    ): Call<DogAPIResponse>
}

