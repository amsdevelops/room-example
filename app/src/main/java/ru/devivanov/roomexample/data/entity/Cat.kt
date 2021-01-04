package ru.devivanov.roomexample.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
data class Cat(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "cat_name") val catName: String,
    @ColumnInfo(name = "cat_age") val catAge:Int
)
