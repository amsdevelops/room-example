package ru.devivanov.roomexample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.devivanov.roomexample.data.dao.CatDao
import ru.devivanov.roomexample.data.entity.Cat

@Database(entities = [Cat::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao
}