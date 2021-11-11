package dev.hmyh.hmyhassignmentthree.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieListVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import dev.hmyh.hmyhassignmentthree.persistance.daos.LatestMovieDao
import dev.hmyh.hmyhassignmentthree.persistance.daos.NowPlayingMovieDao
import dev.hmyh.hmyhassignmentthree.persistance.typeconverters.NowPlayingMovieTypeConverter

@Database(
    entities = [
        LatestMovieVO::class,
        NowPlayingMovieListVO::class,
        NowPlayingMovieVO::class], version = 1, exportSchema = false
)
@TypeConverters(
    NowPlayingMovieTypeConverter::class
)
abstract class HmyhAssignmentThreeDatabase : RoomDatabase() {

    abstract fun latestMovieDao(): LatestMovieDao
    abstract fun nowPlayingMovieDao(): NowPlayingMovieDao

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