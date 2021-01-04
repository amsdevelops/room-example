package ru.devivanov.roomexample.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "cat_beds", foreignKeys = [ForeignKey(
    entity = Cat::class,
    parentColumns = ["id"],
    childColumns = ["cat_id"],
    onDelete = ForeignKey.CASCADE
)]
)
data class CatBad(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bed_model: String,
    @ColumnInfo(name = "cat_id")val catId: Int
    )

