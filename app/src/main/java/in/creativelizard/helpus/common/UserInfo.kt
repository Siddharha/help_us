package `in`.creativelizard.helpus.common

import com.chibatching.kotpref.KotprefModel

object UserInfo : KotprefModel() {
    var upiAddress by stringPref()
}