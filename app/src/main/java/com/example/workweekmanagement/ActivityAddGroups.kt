package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.workweekmanagement.data.DBHelperGroups
import com.example.workweekmanagement.data.DataSourceGroup

class ActivityAddGroups : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addgroups)
        var helper = DBHelperGroups(applicationContext)

        val groupname: EditText = findViewById(R.id.editgroupaddgroupname)

        val buttonok: Button = findViewById(R.id.addgroupokbutton)
        buttonok.setOnClickListener {
            DataSourceGroup().insertGroup(
                helper,
                groupname.text.toString()
            )
            Intent(this, ActivityGroups::class.java).also {
                startActivity(it)
            }
        }

        val buttoncancel: Button = findViewById(R.id.addgroupcancelbutton)
        buttoncancel.setOnClickListener {
            Intent(this, ActivityGroups::class.java).also {
                startActivity(it)
            }
        }
    }
}