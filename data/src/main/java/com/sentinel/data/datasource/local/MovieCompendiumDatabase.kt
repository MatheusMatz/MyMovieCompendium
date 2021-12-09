package com.sentinel.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sentinel.data.datasource.local.dao.GenreDao
import com.sentinel.data.datasource.local.dao.MovieDao
import com.sentinel.data.datasource.local.entities.GenreEntity
import com.sentinel.data.datasource.local.entities.MovieEntity

@Database(entities = [MovieEntity::class, GenreEntity::class], version = 1, exportSchema = false)
abstract class MovieCompendiumDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun genreDao(): GenreDao

    companion object {

        @Volatile
        private var instance: MovieCompendiumDatabase? = null

        fun getDatabase(context: Context): MovieCompendiumDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(
                appContext,
                MovieCompendiumDatabase::class.java,
                "movie_compendium"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}
