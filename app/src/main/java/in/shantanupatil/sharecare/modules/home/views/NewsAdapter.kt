package `in`.shantanupatil.sharecare.modules.home.views

import `in`.shantanupatil.sharecare.databinding.NewsItemBinding
import `in`.shantanupatil.sharecare.modules.home.models.Article
import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager

/**
 * News adapter class for home fragment.
 */
class NewsAdapter(val requestManager: RequestManager) :
    RecyclerView.Adapter<NewsAdapter.NewsItemHolder>() {

    /**
     * Holds the articles.
     */
    private var articles: List<Article> = listOf()

    /**
     * Submits the article and notifies about dataset change.
     */
    fun submitArticle(articlesList: List<Article>) {
        articles = articlesList
        notifyDataSetChanged()
    }

    inner class NewsItemHolder(var binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.tvNewsTitle.text = article.title
            binding.tvMetaInfo.text = ApplicationUtils.getNewsMetaInfo(article)
            requestManager
                .load(article.urlToImage)
                .into(binding.ivNewsThumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemHolder {
        return NewsItemHolder(
            NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsItemHolder, position: Int) {
        holder.bind(articles[position])
    }
}