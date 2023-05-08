package com.example.fitbit_part1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drink_table")
    fun getAll(): List<Drink>
    @Insert
    fun insert(drink: Drink)

    @Query("DELETE FROM drink_table")
    fun deleteAll()
}