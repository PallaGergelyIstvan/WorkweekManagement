package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.workweekmanagement.data.DBHelperMain
import com.example.workweekmanagement.data.DataSource

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        var helper = DBHelperMain(applicationContext)

        val settingsnewpassoldpassedit: EditText = findViewById(R.id.settingsnewpassoldpassedit)
        val settingsnewpassnewpassoneedit: EditText = findViewById(R.id.settingsnewpassnewpassoneedit)
        val settingsnewpassnewpasstwoedit: EditText = findViewById(R.id.settingsnewpassnewpasstwoedit)

        val settingnewpassword: Button = findViewById(R.id.settingnewpassword)
        val settingslogout: Button = findViewById(R.id.settingslogout)

        settingnewpassword.setOnClickListener {
            if(settingsnewpassnewpassoneedit.text.toString().equals(settingsnewpassnewpasstwoedit.text.toString())){
                DataSource().newPassword(helper, settingsnewpassoldpassedit.text.toString(), settingsnewpassnewpassoneedit.text.toString())
                DataSource().logOut(helper)
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

        settingslogout.setOnClickListener {
            DataSource().logOut(helper)
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
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