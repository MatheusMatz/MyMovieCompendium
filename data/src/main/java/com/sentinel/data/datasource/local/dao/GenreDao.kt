package com.sentinel.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sentinel.data.datasource.local.entities.GenreEntity

@Dao
interface GenreDao {

    @Query("SELECT * FROM genres")
    suspend fun getGenres(): List<GenreEntity>

    @Query("SELECT * FROM genres WHERE id = :id")
    suspend fun getGenreByID(id: Long): GenreEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGenre(movies: List<GenreEntity>)
}