package cl.smu.unimarcapp.data.netwok.api

import cl.admedios.searchml.model.ResponseSearch
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetroService {
    /*  Services  */
    //*** Product *** get list ***//
    @GET("{SITE_ID}/search")
    suspend fun getSearchList(
        @Path("SITE_ID") SITE_ID: String,
        @Query("q") search: String,
        @Query("limit") limit: String
    ): Response<ResponseSearch>

    //*** Product *** get detail ***//
/*    @GET("breed/{breedName}/images")
    fun getDogImages(
            @Path("breedName") breedName: String
    ): Call<DogAPIResponse>*/
}

