package `in`.creativelizard.helpus.sos

import `in`.creativelizard.helpus.repos.DonateRepo
import `in`.creativelizard.helpus.repos.FundRepo
import `in`.creativelizard.helpus.repos.ProfileRepo
import `in`.creativelizard.helpus.viewmodels.DonateViewModel
import `in`.creativelizard.helpus.viewmodels.FundViewModel
import `in`.creativelizard.helpus.viewmodels.ProfileViewModel
import com.chibatching.kotpref.Kotpref
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

val appModule = module {

    // single instance of HelloRepository
    single { DonateRepo() }
    single { ProfileRepo() }
    single { FundRepo() }
    single { Kotpref.init(get()) }
   // single<HelloRepository> { HelloRepositoryImpl() }

    // MyViewModel ViewModel
    viewModel { DonateViewModel(get(),get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { FundViewModel(get()) }
   // viewModel { MyViewModel(get()) }
}