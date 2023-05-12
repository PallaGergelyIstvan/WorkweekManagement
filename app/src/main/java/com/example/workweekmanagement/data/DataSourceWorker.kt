package com.example.workweekmanagement.data

import com.example.workweekmanagement.model.Workers

class DataSourceWorker {

    fun loadMain(helper: DBHelperMain): String {

        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM SELF",null)
        rs.moveToFirst()
        return rs.getString(1)
    }

    fun loadWorkers(helper: DBHelperWorkers): MutableList<Workers> {

        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM worker CROSS JOIN task ON worker.Name=task.Name",null)
        rs.moveToFirst()

        val workers = mutableListOf<Workers>()
        while (rs.moveToNext()) {
            workers.add(Workers(rs.getInt(0), rs.getString(1), rs.getString(2),
                rs.getString(3), rs.getInt(4), rs.getInt(5),
                rs.getString(6), rs.getString(7), rs.getString(8),
                rs.getString(9), rs.getString(10),
                rs.getString(11), rs.getString(12), rs.getInt(13)))
        }

        return workers

    }

    fun inserWorker(helper: DBHelperWorkers, workername: String, workertitle: String, workerstart: String, workerend: String, workercomment: String, workerfinished: String){
        helper.readableDatabase.execSQL("INSERT INTO worker (Name, Creator, TaskTitle, TimeStart, TimeEnd, Comment, Finished, Closed) VALUES" +
                "('" + workername +
                "', 'aaaa" +
                "', '" + workertitle +
                "', '" + workerstart +
                "', '" + workerend +
                "', '" + workercomment +
                "', '" + workerfinished + "', 0);")
    }

    fun updateWorker(helper: DBHelperWorkers, id: Int, workername: String, workertitle: String, workerstart: String, workerend: String, workercomment: String, workerfinished: String, closed: Int){
        helper.readableDatabase.execSQL("UPDATE worker " +
                "SET " +
                "Name = '" + workername + "', " +
                "TaskTitle = '" + workertitle + "', " +
                "TimeStart = '" + workerstart + "', " +
                "TimeEnd  = '" + workerend + "', " +
                "Comment = '" + workercomment + "', " +
                "Finished = '" + workerfinished + "', " +
                "Closed = " + closed + " " +
                "WHERE ID = " + id + ";")
    }

    fun deleteWorker(helper: DBHelperWorkers, id: Int){
        helper.readableDatabase.execSQL("DELETE FROM worker " +
                "WHERE ID = " + id + ";")
    }
}