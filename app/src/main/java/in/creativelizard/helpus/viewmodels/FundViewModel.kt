package `in`.creativelizard.helpus.viewmodels

import `in`.creativelizard.helpus.models.Fund
import `in`.creativelizard.helpus.repos.FundRepo
import `in`.creativelizard.helpus.views.DonateActivity
import `in`.creativelizard.helpus.views.FundActivity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FundViewModel(fundRepo: FundRepo) : BaseViewModel() {
    val fundData = fundRepo.getFundData()
    val isContributeEvent = MutableLiveData<Boolean>()
    fun onContributeEvent(){
        isContributeEvent.value = true
    }

    fun navigateToDonateActivity(fundActivity: FundActivity) {
        if(isContributeEvent.value!!){
            fundActivity.startActivity(Intent(fundActivity.baseContext,DonateActivity::class.java))
        }
    }
}