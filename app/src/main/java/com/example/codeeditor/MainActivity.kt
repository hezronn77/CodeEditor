package com.example.codeeditor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var userCode: AutoCompleteTextView
    lateinit var runCode: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userCode = findViewById(R.id.user_code)
        runCode = findViewById(R.id.run_button)


        runCode.setOnClickListener{
            Run()
        }
    }

    private fun Run() {
        

        val intent = Intent(this@MainActivity, CodeActivity::class.java)
        intent.putExtra("code", userCode.text.toString())
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.run_menu -> {
                Run()
                return true
            }

            R.id.add_html_code ->{
                userCode.setText("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<title>Page Title</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "<h1>This is a Heading</h1>\n" +
                        "<p>This is a paragraph.</p>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>")

                return true
            }

            R.id.clear_code -> {
                userCode.setText("")

                return true
            }

            R.id.close -> {
                finish()

                return true

            }
        }

        return super.onOptionsItemSelected(item)
    }


}