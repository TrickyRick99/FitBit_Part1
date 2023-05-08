package com.example.fitbit_part1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.reflect.typeOf
public lateinit var db: AppDatabase
class MainActivity : AppCompatActivity() {

    private lateinit var drinkRecycler: RecyclerView

    private var drinkSet = listOf<Drink>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val add= findViewById<Button>(R.id.addButton)
        drinkRecycler=findViewById(R.id.drinkRec)
        db= AppDatabase.getDatabase(this)


        GlobalScope.launch(Dispatchers.IO){

            val drinkSet = db.drinkDao().getAll()
            Log.v("LOOOOOOOOOOOOOOGG",drinkSet.toString())
            val adapter = DrinkAdapter( drinkSet)
            drinkRecycler.adapter = adapter



        }
        drinkRecycler.layoutManager = LinearLayoutManager(this)












        add.setOnClickListener(){
            val intent1= Intent(this, DetailActivity :: class.java)

            this.startActivity(intent1)
        }
    }
}