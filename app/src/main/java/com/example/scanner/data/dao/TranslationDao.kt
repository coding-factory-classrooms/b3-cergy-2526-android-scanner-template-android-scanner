package com.example.scanner.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.scanner.data.model.Translation
import kotlinx.coroutines.flow.Flow

@Dao
interface TranslationDao {
    
    @Query("SELECT * FROM translation ORDER BY createAt DESC")
    fun getAll(): Flow<List<Translation>>
    
    @Query("SELECT * FROM translation WHERE isFave = 1 ORDER BY createAt DESC")
    fun getFavorites(): Flow<List<Translation>>
    
    @Query("SELECT * FROM translation WHERE id = :id")
    suspend fun getById(id: Long): Translation?
    
    @Insert
    suspend fun insert(translation: Translation): Long
    
    @Update
    suspend fun update(translation: Translation)
    
    @Delete
    suspend fun delete(translation: Translation)
    
    @Query("DELETE FROM translation WHERE id = :id")
    suspend fun deleteById(id: Long)
    
    @Query("UPDATE translation SET isFave = :isFave WHERE id = :id")
    suspend fun updateFavorite(id: Long, isFave: Boolean)
    
    @Query("DELETE FROM translation")
    suspend fun deleteAll()
}
