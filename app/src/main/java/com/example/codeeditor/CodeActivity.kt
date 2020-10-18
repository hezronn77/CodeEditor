package com.example.codeeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView

class CodeActivity : AppCompatActivity() {

    lateinit var webBrowser: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        webBrowser = findViewById(R.id.web_browser)

        webBrowser.loadData(intent.getStringExtra("code").toString(), "text/html; charset=utf-8", null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.js_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.enabe_js ->{
                webBrowser.settings.javaScriptEnabled

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}