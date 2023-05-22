package com.example.workweekmanagement.data

import android.widget.LinearLayout
import android.widget.TextView
import com.example.workweekmanagement.model.Tasks

class DataSource {

    fun loadMain(helper: DBHelperMain): String {
        var logged: String = "0"
        var db = helper.readableDatabase
        var rse = db.rawQuery("SELECT * FROM self", null)
        if(rse.moveToFirst()){
            var rsl = db.rawQuery("SELECT * FROM worker WHERE Name LIKE '" + rse.getString(1) + "' AND Password LIKE '" + rse.getString(2) + "'", null)
            if(rsl.moveToFirst()){
                logged = rsl.getString(1)
            }
        }
        return logged
    }

    fun loadLogin(helper: DBHelperMain, name: String, pass: String): String {
        var logged: String = "0"
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM worker WHERE Name LIKE '" + name + "' AND Password LIKE '" + DataEncryption().toHexString(DataEncryption().getSHA(pass)) + "'", null)
        if(rs.moveToFirst()){
            helper.readableDatabase.execSQL(
                "INSERT INTO self(Name, Password, Email, Strength) " +
                        "VALUES('" + rs.getString(1) + "', '" + rs.getString(2) + "', '" + rs.getString(3) + "', " + rs.getInt(4) + ")"

            )
            logged = rs.getString(1)
        }
        return logged
    }

    fun logOut(helper: DBHelperMain) {
        helper.readableDatabase.execSQL(
            "DELETE FROM self;"
        )
    }

    fun newPassword(helper: DBHelperMain, oldpass: String, newpass: String) {
        var logged: String = "0"
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM self", null)
        if(rs.moveToFirst()){
            if (rs.getString(2).equals(DataEncryption().toHexString(DataEncryption().getSHA(oldpass)))) {
                helper.readableDatabase.execSQL(
                    "UPDATE worker " +
                            "SET " +
                            "Password = '" + DataEncryption().toHexString(DataEncryption().getSHA(newpass)) + "' " +
                            "WHERE Email = '" + rs.getString(3) + "';"
                )
            }
        }
    }

    fun loadTasks(helper: DBHelperTasks): MutableList<Tasks> {

        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM worker CROSS JOIN task ON worker.Name=task.Name", null)

        val tasks = mutableListOf<Tasks>()
        while (rs.moveToNext()) {
            tasks.add(
                Tasks(
                    rs.getInt(0),
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getInt(13)
                )
            )
        }

        return tasks
    }

    fun insertTask(
        helper: DBHelperTasks,
        taskname: String,
        tasktitle: String,
        taskstart: String,
        taskend: String,
        taskcomment: String,
        taskfinished: String
    ) {
        helper.readableDatabase.execSQL(
            "INSERT INTO task (Name, Creator, TaskTitle, TimeStart, TimeEnd, Comment, Finished, Closed) VALUES" +
                    "('" + taskname +
                    "', 'aaaa" +
                    "', '" + tasktitle +
                    "', '" + taskstart +
                    "', '" + taskend +
                    "', '" + taskcomment +
                    "', '" + taskfinished + "', 0);"
        )
    }

    fun updateTask(
        helper: DBHelperTasks,
        id: Int,
        taskname: String,
        tasktitle: String,
        taskstart: String,
        taskend: String,
        taskcomment: String,
        taskfinished: String,
        closed: Int
    ) {
        helper.readableDatabase.execSQL(
            "UPDATE task " +
                    "SET " +
                    "Name = '" + taskname + "', " +
                    "TaskTitle = '" + tasktitle + "', " +
                    "TimeStart = '" + taskstart + "', " +
                    "TimeEnd  = '" + taskend + "', " +
                    "Comment = '" + taskcomment + "', " +
                    "Finished = '" + taskfinished + "', " +
                    "Closed = " + closed + " " +
                    "WHERE ID = " + id + ";"
        )
    }

    fun deleteTask(helper: DBHelperTasks, id: Int) {
        helper.readableDatabase.execSQL(
            "DELETE FROM task " +
                    "WHERE ID = " + id + ";"
        )
    }
}