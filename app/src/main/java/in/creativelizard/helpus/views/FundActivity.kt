package `in`.creativelizard.helpus.views

import `in`.creativelizard.helpus.R
import `in`.creativelizard.helpus.databinding.ActivityFundBinding
import `in`.creativelizard.helpus.viewmodels.FundViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class FundActivity : AppCompatActivity() {
    private val fundViewModel:FundViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityFundBinding>(this,R.layout.activity_fund)
        binding.fundViewModel = fundViewModel
        binding.lifecycleOwner = this

        onActionPerform()
    }

    private fun onActionPerform(){
        fundViewModel.isContributeEvent.observe(this,{
            fundViewModel.navigateToDonateActivity(this)
        })
    }
}