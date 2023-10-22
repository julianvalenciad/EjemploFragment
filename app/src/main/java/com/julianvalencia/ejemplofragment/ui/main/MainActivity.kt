package com.julianvalencia.ejemplofragment.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.julianvalencia.ejemplofragment.databinding.ActivityMainBinding
import com.julianvalencia.ejemplofragment.ui.bottom.BottomNavigationActivity
import com.julianvalencia.ejemplofragment.ui.masterdetail.MasterDetailActivity
import com.julianvalencia.ejemplofragment.ui.navdrawer.NavigationDrawerActivity
import com.julianvalencia.ejemplofragment.ui.tabbed.TabbedActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.button.setOnClickListener {
            val intent = Intent(this, MasterDetailActivity::class.java)
            startActivity(intent)
        }

        mainBinding.button2.setOnClickListener {
            val intent = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(intent)
        }

        mainBinding.button3.setOnClickListener {
            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }

        mainBinding.button4.setOnClickListener {
            val intent = Intent(this, TabbedActivity::class.java)
            startActivity(intent)
        }
    }
}