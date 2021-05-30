package com.sentinel.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sentinel.data.datasource.local.entities.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE isTrendy = :isTrendy")
    suspend fun getTrendiesMovies(isTrendy: Boolean): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendiesMovies(movies: List<MovieEntity>)

}
