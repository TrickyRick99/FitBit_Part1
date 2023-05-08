package com.example.fitbit_part1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Drink :: class], version = 1 )
abstract class AppDatabase: RoomDatabase() {

    abstract fun drinkDao(): DrinkDao
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val curInstance=INSTANCE
            if(curInstance!=null){
                return curInstance;
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "app_database"
                ).build()
                INSTANCE=instance
                return instance
            }

        }
    }
}