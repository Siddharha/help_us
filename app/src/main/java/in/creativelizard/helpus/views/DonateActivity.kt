package `in`.creativelizard.helpus.views

import `in`.creativelizard.helpus.R
import `in`.creativelizard.helpus.databinding.ActivityDonateBinding
import `in`.creativelizard.helpus.viewmodels.DonateViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.viewModel

class DonateActivity : AppCompatActivity() {
    private val donateViewModel: DonateViewModel by viewModel()
    //private val donateViewModel: DonateViewModel by lazy { ViewModelProvider(this).get(DonateViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDonateBinding>(this,R.layout.activity_donate)
        binding.donateViewModel = donateViewModel
        binding.lifecycleOwner = this

        onActionPerform()
    }

    private fun onActionPerform(){
        donateViewModel.onPaymentEvent.observe(this,{
            donateViewModel.doPaymentByUPI(this)
        })

        donateViewModel.onProfileEvent.observe(this,{
            donateViewModel.doNavigateToProfile(this)
        })
    }
}