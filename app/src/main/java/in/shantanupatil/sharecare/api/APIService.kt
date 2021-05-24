package `in`.shantanupatil.sharecare.api

import `in`.shantanupatil.sharecare.modules.home.models.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The API Service interface.
 */
interface APIService {

    /**
     * Searches for the given query on everything endpoint.
     */
    @GET("everything")
    suspend fun getArticles(
        @Query("apiKey") apikey: String,
        @Query("q") query: String
    ): Response<ArticleResponse>
}