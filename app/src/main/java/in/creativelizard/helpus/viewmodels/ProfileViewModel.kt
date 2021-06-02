package `in`.creativelizard.helpus.viewmodels

import `in`.creativelizard.helpus.common.UserInfo
import `in`.creativelizard.helpus.repos.ProfileRepo
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProfileViewModel(private val profileRepo:ProfileRepo) : BaseViewModel() {
    val upiId = MutableLiveData<String>()
    val isBackPressed = MutableLiveData<Boolean>()

    init {
        upiId.value = profileRepo.loadUPIAddress()

    }

    fun onBackButtonEvent(){
        profileRepo.updateUserUpi(upiId)
        isBackPressed.value = true
    }
}