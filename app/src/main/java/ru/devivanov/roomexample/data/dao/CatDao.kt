package ru.devivanov.roomexample.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.devivanov.roomexample.data.entity.Cat

@Dao
interface CatDao {
    @Query("SELECT * FROM cat_table")
    fun getAll(): List<Cat>

    @Insert
    fun insertAll(cats: List<Cat>)
}