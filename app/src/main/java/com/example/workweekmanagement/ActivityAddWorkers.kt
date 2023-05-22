package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.workweekmanagement.data.DBHelperWorkers
import com.example.workweekmanagement.data.DataSourceWorker

class ActivityAddWorkers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addworkers)

        var helper = DBHelperWorkers(applicationContext)


        val workername: EditText = findViewById(R.id.editworkeraddworkername)
        val workeremail: EditText = findViewById(R.id.editworkeraddworkerworkeremail)
        val workerstrength: EditText = findViewById(R.id.editworkeraddworkerstrength)


        val buttonok: Button = findViewById(R.id.addworkerokbutton)
        buttonok.setOnClickListener {
            val password: String = "12345678"
            DataSourceWorker().insertWorker(
                helper,
                workername.text.toString(),
                workeremail.text.toString(),
                password,
                Integer.parseInt(workerstrength.text.toString())
            )
            Intent(this, ActivityWorkers::class.java).also {
                startActivity(it)
            }
        }

        val buttoncancel: Button = findViewById(R.id.addworkercancelbutton)
        buttoncancel.setOnClickListener {
            Intent(this, ActivityWorkers::class.java).also {
                startActivity(it)
            }
        }
    }
}