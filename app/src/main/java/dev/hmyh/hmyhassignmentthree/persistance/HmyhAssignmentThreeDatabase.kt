package dev.hmyh.hmyhassignmentthree.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.hmyh.hmyhassignmentthree.data.vos.*
import dev.hmyh.hmyhassignmentthree.persistance.daos.*
import dev.hmyh.hmyhassignmentthree.persistance.typeconverters.GenreTypeConverter
import dev.hmyh.hmyhassignmentthree.persistance.typeconverters.MovieTypeConverter
import dev.hmyh.hmyhassignmentthree.persistance.typeconverters.MovieVideoTypeConverter
import dev.hmyh.hmyhassignmentthree.persistance.typeconverters.ProductionCountryTypeConverter

@Database(
    entities = [
        NowPlayingMovieVO::class,
        PopularMovieVO::class,
        TopRatedMovieVO::class,
        UpComingMovieVO::class,
        MovieDetailVO::class,
        MovieVideoVO::class
    ], version = 1, exportSchema = false
)
@TypeConverters(
    MovieTypeConverter::class,
    GenreTypeConverter::class,
    MovieVideoTypeConverter::class,
    ProductionCountryTypeConverter::class
)
abstract class HmyhAssignmentThreeDatabase : RoomDatabase() {

    abstract fun nowPlayingMovieDao(): NowPlayingMovieDao
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun topRatedMovieDao(): TopRatedMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun movieDetailDao(): MovieDetailDao
    abstract fun movieVideoDao(): MovieVideoDao

    companion object {

        @Volatile
        private var INSTANCE: HmyhAssignmentThreeDatabase? = null

        private const val DB_NAME = "HmyhAssignmentThree.db"

        fun getDatabase(context: Context): HmyhAssignmentThreeDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HmyhAssignmentThreeDatabase::class.java, DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }

}