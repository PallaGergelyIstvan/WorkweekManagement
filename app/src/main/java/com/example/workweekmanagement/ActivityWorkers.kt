package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.workweekmanagement.adapter.WorkersItemAdapter
import com.example.workweekmanagement.data.DBHelperWorkers
import com.example.workweekmanagement.data.DataSourceWorker

class ActivityWorkers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workers)

        var helper = DBHelperWorkers(applicationContext)

        val myDataset = DataSourceWorker().loadWorkers(helper)
        val rv: RecyclerView = findViewById(R.id.recycler_view_workers)

        val workerupdatell: LinearLayout = findViewById(R.id.workerUpdatelinearLayout)
        val workermenuupdatell: LinearLayout = findViewById(R.id.workerUpdateMenulinearLayout)
        val workerrvll: LinearLayout = findViewById(R.id.workerlinearLayout2)

        val workername: EditText = findViewById(R.id.editworkerupdateworkername)
        val workeremail: EditText = findViewById(R.id.editworkerupdateworkerworkeremail)
        val workerstrength: EditText = findViewById(R.id.editworkerupdateworkerstrength)
        val workerid: TextView = findViewById(R.id.workerupdateworkerworkeridreal)
        val workerpasswordreset: CheckBox = findViewById(R.id.workerupdateworkerworkerpasswordresetcheckBox)

        val buttonaddworker: Button = findViewById(R.id.workeraddworkerbutton)
        val buttonok: Button = findViewById(R.id.updateworkerokbutton)
        val buttondelete: Button = findViewById(R.id.updateworkerdeletebutton)
        val buttoncancel: Button = findViewById(R.id.updateworkercancelbutton)

        rv.adapter = WorkersItemAdapter(
            rv,
            workerupdatell,
            workermenuupdatell,
            workerrvll,
            buttonaddworker,
            workername,
            workeremail,
            workerstrength,
            workerid,
            this,
            myDataset
        )

        rv.setHasFixedSize(false)

        buttonaddworker.setOnClickListener {
            Intent(this, ActivityAddWorkers::class.java).also {
                startActivity(it)
            }
        }

        buttonok.setOnClickListener {
            if (workerpasswordreset.isChecked) {
                DataSourceWorker().updateWorkerPasswordChange(
                    helper,
                    Integer.parseInt(workerid.text.toString()),
                    "12345678"
                )
            }
            DataSourceWorker().updateWorker(
                helper,
                Integer.parseInt(workerid.text.toString()),
                workername.text.toString(),
                workeremail.text.toString(),
                Integer.parseInt(workerstrength.text.toString())
            )
            workerrvll.isVisible = true
            buttonaddworker.isVisible = true
            workerupdatell.isGone = true
            workermenuupdatell.isGone = true
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        buttondelete.setOnClickListener {
            DataSourceWorker().deleteWorker(helper, Integer.parseInt(workerid.text.toString()))
            workerrvll.isVisible = true
            buttonaddworker.isVisible = true
            workerupdatell.isGone = true
            workermenuupdatell.isGone = true
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        buttoncancel.setOnClickListener {
            workerrvll.isVisible = true
            buttonaddworker.isVisible = true
            workerupdatell.isGone = true
            workermenuupdatell.isGone = true
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