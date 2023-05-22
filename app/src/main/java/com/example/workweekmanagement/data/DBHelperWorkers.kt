package com.example.workweekmanagement.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelperWorkers(context: Context) : SQLiteOpenHelper(context, "WORKDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}