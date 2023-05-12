package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.workweekmanagement.adapter.TasksItemAdapter
import com.example.workweekmanagement.data.DBHelperTasks
import com.example.workweekmanagement.data.DataSource

class ActivityTasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        var helper = DBHelperTasks(applicationContext)

        val myDataset = DataSource().loadTasks(helper)
        val rv : RecyclerView = findViewById(R.id.recycler_view_tasks)

        val taskupdatell : LinearLayout = findViewById(R.id.TaskUpdatelinearLayout)
        val taskmenuupdatell : LinearLayout = findViewById(R.id.TaskUpdateMenulinearLayout)
        val taskrvll : LinearLayout = findViewById(R.id.linearLayout2)

        val taskname: EditText = findViewById(R.id.edittaskupdatetaskname)
        val tasktitle: EditText = findViewById(R.id.edittaskupdatetasktasktitle)
        val taskstart: EditText = findViewById(R.id.edittaskupdatetasktimestart)
        val taskend: EditText = findViewById(R.id.edittaskupdatetasktimeend)
        val taskcomment: EditText = findViewById(R.id.edittaskupdatetasktcomment)
        val taskfinished: EditText = findViewById(R.id.edittaskupdatetaskfinished)
        val taskid: TextView = findViewById(R.id.taskupdatetasktaskidreal)
        val taskclosed: CheckBox = findViewById(R.id.taskupdatetasktaskclosedcheckBox)

        val buttonaddtask: Button = findViewById(R.id.taskaddtaskbutton)
        val buttonok: Button = findViewById(R.id.updatetaskokbutton)
        val buttondelete: Button = findViewById(R.id.updatetaskdeletebutton)
        val buttoncancel: Button = findViewById(R.id.updatetaskcancelbutton)

        rv.adapter = TasksItemAdapter(rv, taskupdatell, taskmenuupdatell, taskrvll, buttonaddtask, taskname, tasktitle, taskstart, taskend, taskcomment, taskfinished, taskid, taskclosed, this, myDataset)

        rv.setHasFixedSize(false)

        buttonaddtask.setOnClickListener {
            Intent(this, ActivityAddTasks::class.java).also {
                startActivity(it)
            }
        }

        val button1: Button = findViewById(R.id.button_menu_main_welcome)
        button1.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        val button3: Button = findViewById(R.id.button_menu_main_workers)
        button3.setOnClickListener {
            Intent(this, ActivityWorkers::class.java).also {
                startActivity(it)
            }
        }

        buttonok.setOnClickListener {
            val closed: Int
            if(taskclosed.isChecked) {
                closed = 1
            } else {
                closed = 0
            }
            DataSource().updateTask(helper, Integer.parseInt(taskid.text.toString()), taskname.text.toString(), tasktitle.text.toString(), taskstart.text.toString(), taskend.text.toString(), taskcomment.text.toString(), taskfinished.text.toString(), closed)
            taskrvll.isVisible = true
            buttonaddtask.isVisible = true
            taskupdatell.isGone = true
            taskmenuupdatell.isGone = true
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        buttondelete.setOnClickListener {
            DataSource().deleteTask(helper, Integer.parseInt(taskid.text.toString()))
            taskrvll.isVisible = true
            buttonaddtask.isVisible = true
            taskupdatell.isGone = true
            taskmenuupdatell.isGone = true
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        buttoncancel.setOnClickListener {
            taskrvll.isVisible = true
            buttonaddtask.isVisible = true
            taskupdatell.isGone = true
            taskmenuupdatell.isGone = true
        }
    }
}