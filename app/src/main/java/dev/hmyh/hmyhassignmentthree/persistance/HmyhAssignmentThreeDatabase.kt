package dev.hmyh.hmyhassignmentthree.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.PopularMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.TopRatedMovieVO
import dev.hmyh.hmyhassignmentthree.persistance.daos.LatestMovieDao
import dev.hmyh.hmyhassignmentthree.persistance.daos.NowPlayingMovieDao
import dev.hmyh.hmyhassignmentthree.persistance.daos.PopularMovieDao
import dev.hmyh.hmyhassignmentthree.persistance.daos.TopRatedMovieDao
import dev.hmyh.hmyhassignmentthree.persistance.typeconverters.MovieTypeConverter

@Database(
    entities = [
        LatestMovieVO::class,
//        NowPlayingMovieListVO::class,
        NowPlayingMovieVO::class,
        PopularMovieVO::class,
        TopRatedMovieVO::class
    ], version = 1, exportSchema = false
)
@TypeConverters(
    MovieTypeConverter::class
)
abstract class HmyhAssignmentThreeDatabase : RoomDatabase() {

    abstract fun latestMovieDao(): LatestMovieDao
    abstract fun nowPlayingMovieDao(): NowPlayingMovieDao
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun topRatedMovieDao(): TopRatedMovieDao

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