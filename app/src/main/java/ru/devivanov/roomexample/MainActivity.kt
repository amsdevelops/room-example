package ru.devivanov.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import ru.devivanov.roomexample.data.AppDatabase
import ru.devivanov.roomexample.data.entity.Cat
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "cat_database"
        ).build()

        val catDao = db.catDao()

        val cats = listOf<Cat>(
            Cat(1, "Barsik", 2),
            Cat(2, "Snejok", 1),
            Cat(3, "Pushistik", 3),
            Cat(4, "Tom", 1),
            Cat(5, "Whiskers", 2),
            Cat(6, "Barton", 1),
        )
        Executors.newSingleThreadExecutor().execute {
            catDao.insertAll(cats)
            println(catDao.getAll())
        }
    }
}