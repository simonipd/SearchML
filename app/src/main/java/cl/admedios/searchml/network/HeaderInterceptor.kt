package cl.admedios.searchml.network

import cl.admedios.searchml.util.Constants.acceptHeader
import cl.admedios.searchml.util.Constants.applicationJson
import cl.admedios.searchml.util.Constants.contentTypeHeader
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */

class HeaderInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader(acceptHeader, applicationJson)
        requestBuilder.addHeader(contentTypeHeader, applicationJson)
        return chain.proceed(requestBuilder.build())
    }
}