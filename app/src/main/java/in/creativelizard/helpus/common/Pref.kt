package `in`.creativelizard.helpus.common

import android.content.Context
import android.content.SharedPreferences

class Pref (context: Context) {
    private val PREF_FILE = context.packageName
    private var spref = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
    //private Activity _activity;

    private var _editorSpref  = spref.edit()
    fun getSharedPreferencesInstance(): SharedPreferences {
        return spref
    }

    fun  getSharedPreferencesEditorInstance() : SharedPreferences.Editor {
        return _editorSpref
    }



    fun  getSession( key : String) : String {
        val value = spref.getString(key, "")
        return value!!
    }

    fun getIntegerSession( key: String) : Int {
        val value = spref.getInt(key, 0)
        return value
    }

    fun getFloatSession( key: String) : Float {
        val value = spref.getFloat(key, 100F)
        return value
    }

    fun  getBoolSession( key : String) : Boolean {
        val value = spref.getBoolean(key, false)
        return value
    }

    fun setSession( key:String,  value:String) {
        _editorSpref.putString(key, value)
        _editorSpref.commit()
    }

    fun setIntSession( key:String,  value: Int) {
        _editorSpref.putInt(key, value)
        _editorSpref.commit()
    }

    fun setFloatSession( key:String,  value: Float) {
        _editorSpref.putFloat(key, value)
        _editorSpref.commit()
    }

    fun setBoolSession( key:String,  value: Boolean) {
        _editorSpref.putBoolean(key, value)
        _editorSpref.commit()
    }


}