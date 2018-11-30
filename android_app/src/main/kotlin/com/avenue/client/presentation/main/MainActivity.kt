package com.avenue.client.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.avenue.client.R
import com.avenue.client.presentation.trips.TripsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, MainFragment.newInstance(), MainFragment::class.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }
}
