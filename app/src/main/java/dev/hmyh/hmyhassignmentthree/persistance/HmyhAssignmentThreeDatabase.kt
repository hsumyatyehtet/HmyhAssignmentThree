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

@Database(
    entities = [
        LatestMovieVO::class,
        NowPlayingMovieVO::class,
        PopularMovieVO::class,
        TopRatedMovieVO::class,
        UpComingMovieVO::class,
    MovieDetailVO::class
    ], version = 1, exportSchema = false
)
@TypeConverters(
    MovieTypeConverter::class,
    GenreTypeConverter::class
)
abstract class HmyhAssignmentThreeDatabase : RoomDatabase() {

    abstract fun latestMovieDao(): LatestMovieDao
    abstract fun nowPlayingMovieDao(): NowPlayingMovieDao
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun topRatedMovieDao(): TopRatedMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun movieDetailDao(): MovieDetailDao

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