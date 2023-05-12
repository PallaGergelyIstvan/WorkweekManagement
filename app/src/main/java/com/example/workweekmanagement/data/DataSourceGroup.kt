package com.example.workweekmanagement.data

import com.example.workweekmanagement.model.Tasks
import com.example.workweekmanagement.model.Workers

class DataSourceGroup {

    fun loadMain(helper: DBHelperMain): String {

        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM SELF",null)
        rs.moveToFirst()
        return rs.getString(1)
    }

    fun loadTasks(helper: DBHelperTasks): MutableList<Tasks> {

        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM worker CROSS JOIN task ON worker.Name=task.Name",null)
        rs.moveToFirst()

        val tasks = mutableListOf<Tasks>()
        while (rs.moveToNext()) {
            tasks.add(Tasks(rs.getInt(0), rs.getString(1), rs.getString(2),
                rs.getString(3), rs.getInt(4), rs.getInt(5),
                rs.getString(6), rs.getString(7), rs.getString(8),
                rs.getString(9), rs.getString(10),
                rs.getString(11), rs.getString(12), rs.getInt(13)))
        }

        return tasks

    }


    fun loadWorkers(helper: DBHelperWorkers): MutableList<Workers> {

        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM worker",null)
        rs.moveToFirst()

        return mutableListOf<Workers>(
            Workers(rs.getString(1), rs.getString(1), "asd", "asd", "asd"),
            Workers("asd", "asd", "asd", "asd", "asd"),
            Workers("asd", "asd", "asd", "asd", "asd"),
            Workers("asd", "asd", "asd", "asd", "asd"),
            Workers("asd", "asd", "asd", "asd", "asd"),
            Workers("asd", "asd", "asd", "asd", "asd"),
        )
    }

    fun inserTask(helper: DBHelperTasks, taskname: String, tasktitle: String, taskstart: String, taskend: String, taskcomment: String, taskfinished: String){
        helper.readableDatabase.execSQL("INSERT INTO task (Name, Creator, TaskTitle, TimeStart, TimeEnd, Comment, Finished, Closed) VALUES" +
                "('" + taskname +
                "', 'aaaa" +
                "', '" + tasktitle +
                "', '" + taskstart +
                "', '" + taskend +
                "', '" + taskcomment +
                "', '" + taskfinished + "', 0);")
    }

    fun updateTask(helper: DBHelperTasks, id: Int, taskname: String, tasktitle: String, taskstart: String, taskend: String, taskcomment: String, taskfinished: String, closed: Int){
        helper.readableDatabase.execSQL("UPDATE task " +
                "SET " +
                "Name = '" + taskname + "', " +
                "TaskTitle = '" + tasktitle + "', " +
                "TimeStart = '" + taskstart + "', " +
                "TimeEnd  = '" + taskend + "', " +
                "Comment = '" + taskcomment + "', " +
                "Finished = '" + taskfinished + "', " +
                "Closed = " + closed + " " +
                "WHERE ID = " + id + ";")
    }

    fun deleteTask(helper: DBHelperTasks, id: Int){
        helper.readableDatabase.execSQL("DELETE FROM task " +
                "WHERE ID = " + id + ";")
    }
}