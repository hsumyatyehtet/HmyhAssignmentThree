package dev.hmyh.hmyhassignmentthree.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieListVO

class NowPlayingMovieTypeConverter {

    @TypeConverter
    fun fromListToGson(list: List<NowPlayingMovieListVO>?): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromGsonToList(json: String): List<NowPlayingMovieListVO>? {
        val typeToken = object : TypeToken<List<NowPlayingMovieListVO>>() {}.type
        return Gson().fromJson(json, typeToken)
    }
}