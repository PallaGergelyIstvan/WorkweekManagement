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
        val rv : RecyclerView = findViewById(R.id.recycler_view_workers)

        val workerupdatell : LinearLayout = findViewById(R.id.workerUpdatelinearLayout)
        val workermenuupdatell : LinearLayout = findViewById(R.id.workerUpdateMenulinearLayout)
        val workerrvll : LinearLayout = findViewById(R.id.workerlinearLayout2)

        val workername: EditText = findViewById(R.id.editworkerupdateworkername)
        val workertitle: EditText = findViewById(R.id.editworkerupdateworkerworkertitle)
        val workerstart: EditText = findViewById(R.id.editworkerupdateworkertimestart)
        val workerend: EditText = findViewById(R.id.editworkerupdateworkertimeend)
        val workercomment: EditText = findViewById(R.id.editworkerupdateworkertcomment)
        val workerfinished: EditText = findViewById(R.id.editworkerupdateworkerfinished)
        val workerid: TextView = findViewById(R.id.workerupdateworkerworkeridreal)
        val workerclosed: CheckBox = findViewById(R.id.workerupdateworkerworkerclosedcheckBox)

        val buttonaddworker: Button = findViewById(R.id.workeraddworkerbutton)
        val buttonok: Button = findViewById(R.id.updateworkerokbutton)
        val buttondelete: Button = findViewById(R.id.updateworkerdeletebutton)
        val buttoncancel: Button = findViewById(R.id.updateworkercancelbutton)

        rv.adapter = WorkersItemAdapter(rv, workerupdatell, workermenuupdatell, workerrvll, buttonaddworker, workername, workertitle, workerstart, workerend, workercomment, workerfinished, workerid, workerclosed, this, myDataset)

        rv.setHasFixedSize(false)

        buttonaddworker.setOnClickListener {
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
            if(workerclosed.isChecked) {
                closed = 1
            } else {
                closed = 0
            }
            DataSourceWorker().updateWorker(helper, Integer.parseInt(workerid.text.toString()), workername.text.toString(), workertitle.text.toString(), workerstart.text.toString(), workerend.text.toString(), workercomment.text.toString(), workerfinished.text.toString(), closed)
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
    }
}