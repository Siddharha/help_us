package `in`.creativelizard.helpus.models
import androidx.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


data class Donate(
    var donateNote: String,
    var name: String,
    var number: String,
    var donate_amount: String,
    var trans_id:String
)

fun Donate.toStringConv():String{
    return "Name: $name, Donation Note: $donateNote, Donate Parson name: $number, Donate amount: $donate_amount"
}

 suspend fun Donate.hasValidData():Boolean{
    return if(this.name.isNotBlank()){
         if(this.number.isNotBlank()){
             if(this.donate_amount.isNotBlank()){
                 this.donateNote.isNotBlank()
             }else{
                 false
             }
        }else{
            false
         }
    } else{
        false
    }
}