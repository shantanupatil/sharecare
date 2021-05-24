package `in`.shantanupatil.sharecare.modules.home.models

data class ArticleResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)