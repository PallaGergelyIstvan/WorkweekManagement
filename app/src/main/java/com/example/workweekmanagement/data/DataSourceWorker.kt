package com.example.workweekmanagement.data

import com.example.workweekmanagement.model.Workers

class DataSourceWorker {

    fun loadWorkers(helper: DBHelperWorkers): MutableList<Workers> {
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM worker", null)
        val workers = mutableListOf<Workers>()
        while (rs.moveToNext()) {
            workers.add(
                Workers(
                    rs.getInt(0), rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4)
                )
            )
        }
        return workers
    }

    fun insertWorker(
        helper: DBHelperWorkers,
        workername: String,
        workeremail: String,
        password: String,
        workerstrength: Int
    ) {
        helper.readableDatabase.execSQL(
            "INSERT INTO worker (Name, Email, Password, Strength) VALUES" +
                    "('" + workername +
                    "', '" + workeremail +
                    "', '" + DataEncryption().toHexString(DataEncryption().getSHA(password)) +
                    "', '" + workerstrength + "');"
        )
    }

    fun updateWorker(helper: DBHelperWorkers, id: Int, workername: String, workeremail: String, workerstrength: Int) {
        helper.readableDatabase.execSQL(
            "UPDATE worker " +
                    "SET " +
                    "Name = '" + workername + "', " +
                    "Email = '" + workeremail + "', " +
                    "Strength = '" + workerstrength + "' " +
                    "WHERE ID = " + id + ";"
        )
    }

    fun updateWorkerPasswordChange(helper: DBHelperWorkers, id: Int, newpassword: String) {
        helper.readableDatabase.execSQL(
            "UPDATE worker " +
                    "SET " +
                    "Password = '" + DataEncryption().toHexString(DataEncryption().getSHA(newpassword)) + "' " +
                    "WHERE ID = " + id + ";"
        )
    }

    fun deleteWorker(helper: DBHelperWorkers, id: Int) {
        helper.readableDatabase.execSQL(
            "DELETE FROM worker " +
                    "WHERE ID = " + id + ";"
        )
    }
}