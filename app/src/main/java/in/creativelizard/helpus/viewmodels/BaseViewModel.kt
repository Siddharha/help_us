package `in`.creativelizard.helpus.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel() {

}

fun ViewModel.launchMain(work: suspend () -> Unit) = CoroutineScope(Dispatchers.IO).launch { work() }.also { addToDispose(it) }
private val disposableJob = mutableListOf<Job>()
fun addToDispose(job: Job) {
    disposableJob.add(job)
}


