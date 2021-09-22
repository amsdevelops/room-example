package ru.devivanov.roomexample.data.dao

import androidx.room.*
import ru.devivanov.roomexample.data.entity.Cat

@Dao
interface CatDao {
    @Query("SELECT * FROM cat_table")
    fun getAll(): List<Cat>

    @Query("SELECT cat_name FROM cat_table")
    fun getSimpleCat(): List<SimpleCat>

    @Query("SELECT * FROM cat_table WHERE cat_name LIKE :search")
    fun searchCatByName(search: String): List<Cat>

    @Query("SELECT * FROM cat_table WHERE cat_age BETWEEN :minAge AND :maxAge")
    fun selectCatsInAgeRange(minAge: Int, maxAge: Int): List<Cat>

    @Query("SELECT * FROM cat_table WHERE cat_age IN (:ages)")
    fun selectCatsWithSpecificAges(ages: Array<Int>): List<Cat>

    @Transaction
    fun deleteAndInsert(catToDelete: Cat, catToInsert: Cat) {
        insertCat(catToInsert)
        deleteCat(catToDelete)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cats: List<Cat>)

    @Insert
    fun insertCat(cat: Cat)

    @Update
    fun updateCat(cat: Cat)

    @Delete
    fun deleteCat(cat: Cat)
}

data class SimpleCat(
    @ColumnInfo(name = "cat_name")val name: String
)