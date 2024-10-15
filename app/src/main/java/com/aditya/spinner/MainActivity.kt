package com.aditya.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val destinationSpinner : Spinner = findViewById(R.id.spinner)
        val packageListView  = findViewById<ListView>(R.id.list1)
        val destinations = arrayOf("Paris","New York","Tokyo")
        val packageForParis= arrayOf("Eiffel Tower","Louvre Museum","PSG Stadium")
        val packageForNewYork = arrayOf("Statue of Liberty", "Central Park","Madison Square Garden")
        val packageForTokyo = arrayOf("Buddha Temple","Mount Fiji","Tokyo Tower")
        val spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,destinations)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        destinationSpinner.adapter=spinnerAdapter

        val initialAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,packageForTokyo)
        packageListView.adapter=initialAdapter

        destinationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedPackages=when(position){
                    0-> packageForTokyo
                    1-> packageForNewYork
                    else-> packageForParis
                }

                val listAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, selectedPackages)
                packageListView.adapter = listAdapter

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing if no item is selected
            }

        }







    }
}