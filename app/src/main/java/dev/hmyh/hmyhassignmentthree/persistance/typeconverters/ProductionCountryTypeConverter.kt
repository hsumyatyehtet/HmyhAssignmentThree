package dev.hmyh.hmyhassignmentthree.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.hmyh.hmyhassignmentthree.data.vos.GenreVO
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.data.vos.ProductionCountryVO

class ProductionCountryTypeConverter {

    @TypeConverter
    fun fromListToGson(list: List<ProductionCountryVO>?): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromGsonToList(json: String): List<ProductionCountryVO>? {
        val typeToken = object : TypeToken<List<ProductionCountryVO>>() {}.type
        return Gson().fromJson(json, typeToken)
    }
}