package `in`.creativelizard.helpus.repos

import `in`.creativelizard.helpus.common.UserInfo
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProfileRepo {
    val upiAddress = MutableLiveData<String>()

    var updateUserUpi : (LiveData<String>)-> Unit = {

        if(!it.value.isNullOrBlank()){
            Log.e("upi",it.value!!)
            upiAddress.value = it.value
        UserInfo.upiAddress = it.value!!
        }

    }

    val loadUPIAddress:() ->String ={
        UserInfo.upiAddress
    }
}