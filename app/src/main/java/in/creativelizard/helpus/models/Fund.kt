package `in`.creativelizard.helpus.models
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


data class Fund(
    var title: String,
    var desc: String,
    var progress: Int,
    var totalAmount: String
)

