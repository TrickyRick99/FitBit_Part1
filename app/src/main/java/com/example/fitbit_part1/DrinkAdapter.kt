package com.example.fitbit_part1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DrinkAdapter ( private val drinks: List<Drink>) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val drinkView: TextView
        val literView: TextView


        init{
            drinkView = itemView.findViewById(R.id.drinkText)
            literView = itemView.findViewById(R.id.literText)

        }
        fun binder(d: Drink){
            drinkView.text=d.drinkName
            literView.text=d.literNum.toString()
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.drink_list, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {

        return drinks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val drinkPos=drinks[position]
        holder.binder(drinkPos)
    }

}