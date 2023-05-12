package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.workweekmanagement.data.DBHelperTasks
import com.example.workweekmanagement.data.DataSource

class ActivityUpdateTasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatetasks)

        var helper = DBHelperTasks(applicationContext)


        val taskname: EditText = findViewById(R.id.edittaskaddupdatetaskname)
        val tasktitle: EditText = findViewById(R.id.edittaskaddupdatetasktasktitle)
        val taskstart: EditText = findViewById(R.id.edittaskaddupdatetasktimestart)
        val taskend: EditText = findViewById(R.id.edittaskaddupdatetasktimeend)
        val taskcomment: EditText = findViewById(R.id.edittaskaddupdatetasktcomment)
        val taskfinished: EditText = findViewById(R.id.edittaskaddupdatetaskfinished)


        val buttonok: Button = findViewById(R.id.addupdatetaskokbutton)
        buttonok.setOnClickListener {
            DataSource().inserTask(helper, taskname.text.toString(), tasktitle.text.toString(), taskstart.text.toString(), taskend.text.toString(), taskcomment.text.toString(), taskfinished.text.toString())
            Intent(this, ActivityTasks::class.java).also {
                startActivity(it)
            }
        }

        val buttondelete: Button = findViewById(R.id.addupdatetaskdeletebutton)
        buttondelete.setOnClickListener {
            Intent(this, ActivityTasks::class.java).also {
                startActivity(it)
            }
        }

        val buttoncancel: Button = findViewById(R.id.addupdatetaskcancelbutton)
        buttoncancel.setOnClickListener {
            Intent(this, ActivityTasks::class.java).also {
                startActivity(it)
            }
        }
    }
}