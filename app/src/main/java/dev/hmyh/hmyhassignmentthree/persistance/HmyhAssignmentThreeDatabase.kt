package dev.hmyh.hmyhassignmentthree.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.persistance.daos.LatestMovieDao

@Database(entities = [
    LatestMovieVO::class]
    ,version = 1,exportSchema = false)
abstract class HmyhAssignmentThreeDatabase: RoomDatabase() {

    abstract fun latestMovieDao(): LatestMovieDao

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