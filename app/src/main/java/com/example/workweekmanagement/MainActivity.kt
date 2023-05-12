package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.workweekmanagement.data.DBHelperMain
import com.example.workweekmanagement.data.DBHelperTasks
import com.example.workweekmanagement.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = DBHelperMain(applicationContext)


        val textViewStartServer : TextView = findViewById(R.id.textViewStartServer) as TextView
        val myDataset = DataSource().loadMain(helper)
        textViewStartServer.setText("Server: " + myDataset)

        val button2: Button = findViewById(R.id.button_menu_main_tasks)
        button2.setOnClickListener {
            Intent(this, ActivityTasks ::class.java).also {
                startActivity(it)
            }
        }

        val button3: Button = findViewById(R.id.button_menu_main_workers)
        button3.setOnClickListener {
            Intent(this, ActivityWorkers::class.java).also {
                startActivity(it)
            }
        }

    }
}