package dev.hmyh.hmyhassignmentthree.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.hmyh.hmyhassignmentthree.data.vos.GenreVO
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO

class GenreTypeConverter {

    @TypeConverter
    fun fromListToGson(list: List<GenreVO>?): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromGsonToList(json: String): List<GenreVO>? {
        val typeToken = object : TypeToken<List<GenreVO>>() {}.type
        return Gson().fromJson(json, typeToken)
    }
}