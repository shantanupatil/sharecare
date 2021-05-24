package `in`.shantanupatil.sharecare.modules.repository

import `in`.shantanupatil.sharecare.api.RetrofitInstance
import `in`.shantanupatil.sharecare.constants.StringConstants
import `in`.shantanupatil.sharecare.modules.home.models.ArticleResponse
import `in`.shantanupatil.sharecare.modules.repository.interfaces.IRemoteDataRepository
import retrofit2.Response

/**
 * The remote data repository class to handle data from remote source.
 */
class RemoteDataRepository : IRemoteDataRepository {

    override suspend fun loadArticles(query: String): Response<ArticleResponse> =
        RetrofitInstance.retrofitApi.getArticles(StringConstants.API_KEY, query)
}