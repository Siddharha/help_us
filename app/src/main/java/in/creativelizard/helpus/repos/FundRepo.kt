package `in`.creativelizard.helpus.repos

import `in`.creativelizard.helpus.models.Fund
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FundRepo {
    private val db = Firebase.firestore

     fun getFundData():LiveData<Fund> {
        val d = MutableLiveData<Fund>()
        db.collection("Campaign")
            .document("flood_donation")
            .get()
            .addOnSuccessListener { result ->
               // Log.e("rsp",result?.data?.get("title") as String)
               d.value =  result.mapToFundObj()
//                for (document in result) {
//
//                    //Log.d(TAG, "${document.id} => ${document.data}")
//                }
            }
            .addOnFailureListener { exception ->
               // Log.w(TAG, "Error getting documents.", exception)
            }

        return d
    }
}

private fun DocumentSnapshot.mapToFundObj(): Fund {
    return Fund(
        title = data?.get("title") as String,
        desc = data?.get("desc") as String,
        totalAmount = data?.get("totalAmount") as String,
        progress = (data?.get("progress") as Long).toInt()
    )
}
