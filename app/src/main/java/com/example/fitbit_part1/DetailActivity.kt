package com.example.fitbit_part1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.fitbit_part1.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    //public lateinit var db: AppDatabase
    private  var classMain= MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

            // db= AppDatabase.getDatabase(this)
        //db=classMain.




        val record= findViewById<Button>(R.id.recordButton)



        record.setOnClickListener(){

            val drinkName=binding.drinkEdit.text.toString()
            val liters=binding.literEdit.text.toString()
            val intent2= Intent(this, MainActivity :: class.java)


            if(drinkName.isNotEmpty() && liters.isNotEmpty()){
                val drink = Drink(null, drinkName,liters.toInt())

                GlobalScope.launch(Dispatchers.IO){
                    db.drinkDao().insert(drink)

                    val drinkList = db.drinkDao().getAll()
                    intent2.putExtra("Testing", drinkList.toString())
                    Log.v("HEYYYYYYYYY",drinkList.toString())

                }
            }


            else{
                Toast.makeText(this,"Enter the drink name and liter amount.",Toast.LENGTH_SHORT).show()

            }

            binding.drinkEdit.text.clear()
            binding.literEdit.text.clear()


            this.startActivity(intent2)
        }
    }
}