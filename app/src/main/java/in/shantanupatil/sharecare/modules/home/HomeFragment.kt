package `in`.shantanupatil.sharecare.modules.home

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.base.BaseFragment
import `in`.shantanupatil.sharecare.constants.StringConstants
import `in`.shantanupatil.sharecare.databinding.FragmentHomeBinding
import `in`.shantanupatil.sharecare.modules.home.models.Resource
import `in`.shantanupatil.sharecare.modules.utils.ApplicationUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

/**
 * HomeFragment class.
 */
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.home))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        setIconVisibility(false)

        setCalendarClickListeners()

        mainViewModel.loadArticles(StringConstants.QUERY)

        observeResponse()
    }

    private fun setCalendarClickListeners() {
        binding.cvHome.setOnDateChangeListener { view, year, month, dayOfMonth ->
            ApplicationUtils.setTimeInMillis(year, month, dayOfMonth)
            navigateToRoutines()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /**
     * Observes the response for news articles.
     */
    private fun observeResponse() {
        mainViewModel.articles.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressbar(binding.pbProgress)
                }

                is Resource.Success -> {
                    response.data?.let { articleResponse ->
                        hideProgressbar(binding.pbProgress)
                    }
                }

                is Resource.Error -> {
                    hideProgressbar(binding.pbProgress)
                    binding.tvNewsForYou.text = getString(R.string.something_went_wrong)
                }
            }
        })
    }
}