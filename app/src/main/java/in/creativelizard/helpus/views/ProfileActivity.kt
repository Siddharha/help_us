package `in`.creativelizard.helpus.views

import `in`.creativelizard.helpus.R
import `in`.creativelizard.helpus.databinding.ActivityProfileBinding
import `in`.creativelizard.helpus.viewmodels.ProfileViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : AppCompatActivity() {

    private val profileViewModel: ProfileViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityProfileBinding>(this,R.layout.activity_profile)
        binding.prefileViewModel = profileViewModel
        binding.lifecycleOwner = this
        onActionPerform()
    }

    private fun onActionPerform() {
        profileViewModel.isBackPressed.observe(this,{
            onBackPressed()
        })
    }
}