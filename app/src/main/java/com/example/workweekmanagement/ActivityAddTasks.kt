package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.workweekmanagement.data.DBHelperTasks
import com.example.workweekmanagement.data.DataSource

class ActivityAddTasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtasks)

        var helper = DBHelperTasks(applicationContext)


        val taskname: EditText = findViewById(R.id.edittaskaddtaskname)
        val tasktitle: EditText = findViewById(R.id.edittaskaddtasktasktitle)
        val taskstart: EditText = findViewById(R.id.edittaskaddtasktimestart)
        val taskend: EditText = findViewById(R.id.edittaskaddtasktimeend)
        val taskcomment: EditText = findViewById(R.id.edittaskaddtasktcomment)
        val taskfinished: EditText = findViewById(R.id.edittaskaddtaskfinished)


        val buttonok: Button = findViewById(R.id.addtaskokbutton)
        buttonok.setOnClickListener {
            DataSource().insertTask(
                helper,
                taskname.text.toString(),
                tasktitle.text.toString(),
                taskstart.text.toString(),
                taskend.text.toString(),
                taskcomment.text.toString(),
                taskfinished.text.toString()
            )
            Intent(this, ActivityTasks::class.java).also {
                startActivity(it)
            }
        }

        val buttoncancel: Button = findViewById(R.id.addtaskcancelbutton)
        buttoncancel.setOnClickListener {
            Intent(this, ActivityTasks::class.java).also {
                startActivity(it)
            }
        }
    }
}