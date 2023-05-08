package com.example.fitbit_part1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drink_table")
data class Drink(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name ="drink_name") val drinkName:String?,
    @ColumnInfo(name = "liter_num") val literNum: Int?,


)
