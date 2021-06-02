package `in`.creativelizard.helpus.viewmodels

import `in`.creativelizard.helpus.common.Constants
import `in`.creativelizard.helpus.common.UserInfo
import `in`.creativelizard.helpus.models.Donate
import `in`.creativelizard.helpus.models.hasValidData
import `in`.creativelizard.helpus.repos.DonateRepo
import `in`.creativelizard.helpus.repos.ProfileRepo
import `in`.creativelizard.helpus.views.DonateActivity
import `in`.creativelizard.helpus.views.ProfileActivity
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*

class DonateViewModel(private val donateRepo:DonateRepo, profileRepo: ProfileRepo) : BaseViewModel(){
     var name:String = ""
     var number:String = ""
     var amount:String = ""
     var note:String = ""
     var upiAddress:MutableLiveData<String> = profileRepo.upiAddress

    val imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSppncfz3iPr0Syrey-ltE4zHLfcGcIAeqf4w&usqp=CAU"
    val onPaymentEvent = MutableLiveData<Boolean>()
    val onProfileEvent = MutableLiveData<Boolean>()

    init {
        upiAddress.value = UserInfo.upiAddress
    }

    fun onDonateAction(){
        onPaymentEvent.value = true
    }

    fun onProfileAction(){
        onProfileEvent.value = true
    }

    private suspend fun getPaymentAccountFormat(amount: String): String {
      return if (amount.isNotBlank()){
           amount.toFloat().toString()
      }else{
          "0.0"
      }
    }
    private suspend fun getTransId(): String{
        val c = Calendar.getInstance().time
        val df = SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault())
        return df.format(c)
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun doPaymentByUPI(donateActivity: DonateActivity) {
        //onPaymentEvent.value = false
            launchMain {
                Donate(note, name, number, getPaymentAccountFormat(amount), getTransId()).apply {
                    if (hasValidData()) {
                        val uri = Uri.parse("upi://pay").buildUpon()
                            .appendQueryParameter("pa", upiAddress.value)
                            .appendQueryParameter("pn", name)
                            .appendQueryParameter("tn", note)
                            .appendQueryParameter("am", amount)
                            .appendQueryParameter("cu", "INR")
                            .build()


                        val upiPayIntent = Intent(Intent.ACTION_VIEW)
                        upiPayIntent.data = uri

                        // will always show a dialog to user to choose an app
                        val chooser = Intent.createChooser(upiPayIntent, "Pay with")

                        // check if intent resolves
                        if (null != chooser.resolveActivity(donateActivity.packageManager)) {
                            //donateActivity.startActivityForResult(chooser, Constants.PAYMENT_REQ)
                            var resultLauncher = donateActivity.registerForActivityResult(
                                    ActivityResultContracts.StartActivityForResult()) {
                                val data: Intent? = it.data

                                print(data)

                            }
                            resultLauncher.launch(chooser)

                        } else {
                            Toast.makeText(donateActivity, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show()
                        }
                    }


                }
            }

    }



    fun doNavigateToProfile(context: Context) {
        context.startActivity(Intent(context,ProfileActivity::class.java))
    }



}