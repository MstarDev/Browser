package com.example.browser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.browser.module.Checking
import kotlinx.android.synthetic.main.activity_google.*

class GoogleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google)

        card_android.setOnClickListener {
            Checking.KnowIt = "android"
            goActivity()
        }
        card_github.setOnClickListener {
            Checking.KnowIt = "github"
            goActivity()
        }

        card_google.setOnClickListener {
            Checking.KnowIt = "google"
            goActivity()
        }

        card_youtube.setOnClickListener {
            Checking.KnowIt = "youtube"
            goActivity()
        }

        search_1.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                Checking.KnowIt = p0.toString()
                goActivity()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return false
            }
        })
    }
    fun goActivity(){
        val intent = Intent(this, SearchingActivity::class.java)
        startActivity(intent)
    }

}