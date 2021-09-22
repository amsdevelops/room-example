package ru.devivanov.roomexample.data.entity

import androidx.room.*

@Entity(tableName = "cat_table")
data class Cat(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "cat_name") val catName: String,
    @ColumnInfo(name = "cat_age") val catAge: Int,
    @ColumnInfo(name = "favorite_food") val favoriteFood: String = ""
)
