package com.example.workweekmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.workweekmanagement.adapter.GroupsItemAdapter
import com.example.workweekmanagement.data.DBHelperGroups
import com.example.workweekmanagement.data.DataSourceGroup

class ActivityGroups : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)

        var helper = DBHelperGroups(applicationContext)
        val myDataset = DataSourceGroup().loadGroups(helper)
        val rv: RecyclerView = findViewById(R.id.recycler_view_groups)

        val groupupdatell: LinearLayout = findViewById(R.id.groupUpdatelinearLayout)
        val groupmenuupdatell: LinearLayout = findViewById(R.id.groupUpdateMenulinearLayout)
        val grouprvll: LinearLayout = findViewById(R.id.grouplinearLayout2)

        val groupid: TextView = findViewById(R.id.groupupdategroupgroupidreal)
        val groupnameforgroup: TextView = findViewById(R.id.groupupdategroupname)
        val groupnameformember: TextView = findViewById(R.id.groupupdategroupgroupmembergroupnamefirst)
        val groupnameformemberreal: TextView = findViewById(R.id.groupupdategroupgroupmembergroupnamereal)
        val groupmembernametext: TextView = findViewById(R.id.groupupdategroupgroupmembername)
        val groupparent: TextView = findViewById(R.id.groupupdategroupgroupparent)
        val groupmemberid: TextView = findViewById(R.id.groupupdategroupgroupmemberid)
        val groupname: EditText = findViewById(R.id.editgroupupdategroupname)
        val groupmembername: EditText = findViewById(R.id.editgroupupdategroupgroupmembername)

        val buttonaddgroupmember: Button = findViewById(R.id.groupaddgroupmemberbutton)
        val buttonaddgroup: Button = findViewById(R.id.groupaddgroupbutton)
        val buttonok: Button = findViewById(R.id.updategroupokbutton)
        val buttondelete: Button = findViewById(R.id.updategroupdeletebutton)
        val buttoncancel: Button = findViewById(R.id.updategroupcancelbutton)

        rv.adapter = GroupsItemAdapter(
            rv,
            groupupdatell,
            groupmenuupdatell,
            grouprvll,
            buttonaddgroup,
            groupid,
            groupnameforgroup,
            groupnameformember,
            groupnameformemberreal,
            groupmembernametext,
            groupparent,
            groupmemberid,
            groupname,
            groupmembername,
            buttonaddgroupmember,
            this,
            myDataset
        )

        rv.setHasFixedSize(false)

        buttonaddgroup.setOnClickListener {
            Intent(this, ActivityAddGroups::class.java).also {
                startActivity(it)
            }
        }

        buttonok.setOnClickListener {
            if (groupparent.text.toString().equals("0")) {
                DataSourceGroup().updateGroupMember(
                    helper,
                    Integer.parseInt(groupmemberid.text.toString()),
                    groupmembername.text.toString()
                )
            } else {
                if (buttonaddgroupmember.isGone == true) {
                    DataSourceGroup().inserGroupMember(
                        helper,
                        groupnameformemberreal.text.toString(),
                        groupmembername.text.toString()
                    )
                } else {
                    DataSourceGroup().updateGroup(
                        helper,
                        Integer.parseInt(groupid.text.toString()),
                        groupname.text.toString()
                    )
                }
            }
            buttonaddgroupmember.isGone = true
            grouprvll.isVisible = true
            buttonaddgroup.isVisible = true
            groupupdatell.isGone = true
            groupmenuupdatell.isGone = true
            buttondelete.isVisible = true
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        buttondelete.setOnClickListener {
            if (groupparent.text.toString().equals("0")) {
                DataSourceGroup().deleteGroupMemeber(
                    helper,
                    Integer.parseInt(groupmemberid.text.toString())
                )
            } else {
                DataSourceGroup().deleteGroup(
                    helper,
                    Integer.parseInt(groupid.text.toString())
                )
            }
            grouprvll.isVisible = true
            buttonaddgroup.isVisible = true
            groupupdatell.isGone = true
            groupmenuupdatell.isGone = true
            buttondelete.isVisible = true
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        buttonaddgroupmember.setOnClickListener {
            groupnameforgroup.isGone = true
            groupname.isGone = true
            groupnameformember.isVisible = true
            groupnameformemberreal.isVisible = true
            groupmembernametext.isVisible = true
            groupmembername.isVisible = true
            buttonaddgroupmember.isGone = true
            buttondelete.isGone = true
        }

        buttoncancel.setOnClickListener {
            buttonaddgroupmember.isGone = true
            grouprvll.isVisible = true
            buttonaddgroup.isVisible = true
            groupupdatell.isGone = true
            groupmenuupdatell.isGone = true
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