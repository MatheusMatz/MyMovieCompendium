package com.sentinel.data.datasource.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object HashMapTypeConverter {

    @TypeConverter
    @JvmStatic
    fun stringToHashMap(value: String): HashMap<String, String> {
        return Gson().fromJson(value,  object : TypeToken<Map<String, String>>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun hashMapToString(value: HashMap<String, String>?): String {
        return if(value == null) "" else Gson().toJson(value)
    }
}
