package com.avenue.client.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.avenue.client.presentation.trips.TripsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content, TripsFragment.newInstance(), TripsFragment::class.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }
}
