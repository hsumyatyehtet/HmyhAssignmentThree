package dev.hmyh.hmyhassignmentthree.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoListVO

class MovieVideoTypeConverter {

    @TypeConverter
    fun fromListToGson(list: List<MovieVideoListVO>?): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromGsonToList(json: String): List<MovieVideoListVO>? {
        val typeToken = object : TypeToken<List<MovieVideoListVO>>() {}.type
        return Gson().fromJson(json, typeToken)
    }
}