package `in`.shantanupatil.sharecare

import `in`.shantanupatil.sharecare.base.BaseActivity
import `in`.shantanupatil.sharecare.databinding.ActivityMainBinding
import `in`.shantanupatil.sharecare.modules.home.HomeFragment
import `in`.shantanupatil.sharecare.modules.interfaces.IFragmentCallsMA
import `in`.shantanupatil.sharecare.modules.routine.AddRoutineActivity
import `in`.shantanupatil.sharecare.modules.routine.RoutineFragment
import `in`.shantanupatil.sharecare.modules.viewmodels.MainViewModel
import `in`.shantanupatil.sharecare.modules.volunteer.views.fragments.VolunteerCategoryFragment
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint

/**
 * Entry point. MainActivity is responsible for holding all fragments shown as bottomNavigationView.
 */
@AndroidEntryPoint
class MainActivity : BaseActivity(), IFragmentCallsMA {

    /**
     * Binding for the main activity.
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        // This will make sure that at the start fragment is set to the home fragment
        switchFragment(HomeFragment())

        setItemSelectedListener()
    }

    override fun getView(): View {
        return binding.root
    }

    /**
     * Switches the fragment in the container.
     */
    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.flContainer.id, fragment).commit()
    }

    /**
     * Sets the item selected listener on bottom navigation and switches fragment according to the
     * selected item.
     */
    private fun setItemSelectedListener() {
        binding.bnvMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.actionHome -> {
                    switchFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.actionVolunteer -> {
                    switchFragment(VolunteerCategoryFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.actionRoutine -> {
                    switchFragment(RoutineFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    override fun title(title: String) {
        binding.tvTitle.text = title
    }

    override fun getViewModel(): MainViewModel {
        return mainViewModel
    }

    override fun getRequestManager_(): RequestManager {
        return requestManager
    }

    override fun setToolbarIconVisibility(shouldShow: Boolean) {
        if (shouldShow) {
            binding.ivAdd.visibility = View.VISIBLE
        } else {
            binding.ivAdd.visibility = View.GONE
        }

        binding.ivAdd.setOnClickListener {
            startActivity(Intent(this, AddRoutineActivity::class.java))
        }
    }
}