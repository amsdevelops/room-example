package ru.devivanov.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.devivanov.roomexample.data.AppDatabase
import ru.devivanov.roomexample.data.entity.Cat
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE cat_table ADD COLUMN favorite_food text NOT NULL DEFAULT ''")
//            }
//        }

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "cat_database")
//            .addMigrations(MIGRATION_1_2)
            .build()

        val catDao = db.catDao()

        val cats = listOf<Cat>(
            Cat(1, "111", 2),
            Cat(2, "2", 1),
            Cat(3, "2", 3),
            Cat(4, "1", 1),
            Cat(5, "1", 2),
            Cat(6, "1", 1),
        )

        Executors.newSingleThreadExecutor().execute {
            catDao.insertAll(cats)
            catDao.deleteAndInsert(cats[0], Cat(catName = "333", catAge = 33))
            println("VVV " + catDao.getAll())
        }
    }
}