package `in`.shantanupatil.sharecare.modules.repository.interfaces

import `in`.shantanupatil.sharecare.modules.home.models.ArticleResponse
import retrofit2.Response

/**
 * The remote data repository.
 */
interface IRemoteDataRepository {

    /**
     * Loads the articles for a query.
     */
    suspend fun loadArticles(query: String): Response<ArticleResponse>
}