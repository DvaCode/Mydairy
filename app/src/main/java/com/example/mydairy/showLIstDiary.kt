package com.example.mydairy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import java.io.File
import android.content.Intent

lateinit var returnBtn : Button


class showLIstDairy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list_diary)

        val fileListView: ListView = findViewById(R.id.fileListView)
        returnBtn = findViewById(R.id.return_btn)

        returnBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val directoryPath = "/data/data/com.example.mydairy/files/"
        val directory = File(directoryPath)
        val files = directory.listFiles()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, files.map {it.name})
        fileListView.adapter = adapter
    }
}