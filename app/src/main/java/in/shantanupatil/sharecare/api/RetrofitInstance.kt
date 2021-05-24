package `in`.shantanupatil.sharecare.api

import `in`.shantanupatil.sharecare.constants.StringConstants
import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Holds the retrofit instance.
 */
class RetrofitInstance {
    companion object {

        private lateinit var context: Context

        fun setContext(context: Context) {
            this.context = context
        }

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(StringConstants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient().newBuilder().build())
                .build()
        }

        // The retrofit api which will be used to call different api functionality
        val retrofitApi by lazy {
            retrofit.create(APIService::class.java)
        }
    }
}