package ru.devivanov.roomexample.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table", indices = [Index(
    value = ["cat_name"],
    unique = true
)])
data class Cat(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "cat_name") val catName: String,
    @ColumnInfo(name = "cat_age") val catAge:Int
)
