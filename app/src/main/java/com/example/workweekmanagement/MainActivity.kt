package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.workweekmanagement.data.DBHelperMain
import com.example.workweekmanagement.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = DBHelperMain(applicationContext)

        val loginname: EditText = findViewById(R.id.loginnameedit)
        val loginpass: EditText = findViewById(R.id.loginpassedit)

        val loggedwelcome: TextView = findViewById(R.id.loggedwelcome)

        val buttonok: Button = findViewById(R.id.loginok)

        val lllogin: LinearLayout = findViewById(R.id.lllogin)
        val linearlayoutmain: LinearLayout = findViewById(R.id.linearLayoutmain)

        val mysself = DataSource().loadMain(helper)
        if (!mysself.equals("0")){
            lllogin.isGone = true
            linearlayoutmain.isVisible = true
            buttonok.isGone = true
            loggedwelcome.isVisible = true
            loggedwelcome.setText("Welcome " + mysself)
        }

        buttonok.setOnClickListener {
            val myDataset = DataSource().loadLogin(helper, loginname.text.toString(), loginpass.text.toString())
            if (!myDataset.equals("0")){
                lllogin.isGone = true
                linearlayoutmain.isVisible = true
                buttonok.isGone = true
                loggedwelcome.isVisible = true
                loggedwelcome.setText("Welcome " + myDataset)
            }
        }

        val button1: Button = findViewById(R.id.button_menu_main_welcome)
        button1.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        val button2: Button = findViewById(R.id.button_menu_main_tasks)
        button2.setOnClickListener {
            Intent(this, ActivityTasks::class.java).also {
                startActivity(it)
            }
        }

        val button3: Button = findViewById(R.id.button_menu_main_workers)
        button3.setOnClickListener {
            Intent(this, ActivityWorkers::class.java).also {
                startActivity(it)
            }
        }

        val button4: Button = findViewById(R.id.button_menu_main_group)
        button4.setOnClickListener {
            Intent(this, ActivityGroups::class.java).also {
                startActivity(it)
            }
        }

        val button5: Button = findViewById(R.id.button_menu_main_setting)
        button5.setOnClickListener {
            Intent(this, Settings::class.java).also {
                startActivity(it)
            }
        }

    }
}