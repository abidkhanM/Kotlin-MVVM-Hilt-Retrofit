package com.example.mvvm.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val keyPrefs = "com.example.gallery_FILE_KEY"
    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor? = null

    init {
        preferences = context.getSharedPreferences(keyPrefs, 0)
        editor = preferences.edit()
    }

    companion object{
        private var instance: PreferencesHelper? = null
        fun getInstance(context: Context): PreferencesHelper {
            if (instance == null) {
                instance = PreferencesHelper(context)
            }
            return instance as PreferencesHelper
        }
    }


    fun getInt(key: String?, defaultValue: Int): Int {
        return preferences.getInt(key, defaultValue)
    }

    fun getInteger(key: String?, defaultValue: Int): Int {
        return preferences.getInt(key, defaultValue)
    }

    fun getFloat(key: String?, defaultValue: Float): Float {
        return preferences.getFloat(key, defaultValue)
    }

    fun getLong(key: String?, defaultValue: Long): Float {
        return preferences.getLong(key, defaultValue).toFloat()
    }

    fun getString(key: String?, defaultValue: String?): String? {
        return preferences.getString(key, defaultValue)
    }

    fun getBoolean(key: String?, defaultValue: Boolean): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    fun putInt(key: String?, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun putInteger(key: String?, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun putFloat(key: String?, value: Float) {
        editor!!.putFloat(key, value)
        editor!!.commit()
    }

    operator fun contains(key: String?): Boolean {
        return preferences.contains(key)
    }

    fun putLong(key: String?, value: Long) {
        editor!!.putLong(key, value)
        editor!!.commit()
    }

    fun putString(key: String?, value: String?) {
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun putBoolean(key: String?, value: Boolean) {
        editor!!.putBoolean(key, value)
        editor!!.commit()
    }

    fun clear() {
        editor!!.clear()
        editor!!.commit()
    }
}