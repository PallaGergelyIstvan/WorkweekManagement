package com.example.workweekmanagement.data

import com.example.workweekmanagement.model.Workers
import com.example.workweekmanagement.model.Groups

class DataSourceGroup {

    fun loadGroups(helper: DBHelperGroups): MutableList<Groups> {
        var db = helper.readableDatabase
        var rsg = db.rawQuery(
            "SELECT * FROM workergroup", null
        )
        val groups = mutableListOf<Groups>()
        while (rsg.moveToNext()) {
                groups.add(
                    Groups(
                        1,
                        rsg.getInt(0),
                        rsg.getString(1),
                        "",
                        0
                    )
                )
            var rsw = db.rawQuery(
                "SELECT * FROM groupmember WHERE GroupName LIKE '" + rsg.getString(1) + "'", null
            )
            while (rsw.moveToNext()) {
                groups.add(
                    Groups(
                        0,
                        rsg.getInt(0),
                        rsg.getString(1),
                        rsw.getString(2),
                        rsw.getInt(0)
                    )
                )
            }
        }
        return groups
    }


    fun loadWorkers(helper: DBHelperWorkers): MutableList<Workers> {
        val workers = mutableListOf<Workers>()
        return workers;
    }

    fun insertGroup(
    helper: DBHelperGroups,
    groupname: String
    ) {
        helper.readableDatabase.execSQL(
            "INSERT INTO workergroup (GroupName) VALUES" +
                    "('" + groupname + "');"
        )
    }

    fun inserGroupMember(
        helper: DBHelperGroups,
        groupname: String,
        groupmembername: String
    ) {
        helper.readableDatabase.execSQL(
            "INSERT INTO groupmember (GroupName, Name) VALUES" +
                    "('" + groupname +
                    "', '" + groupmembername + "');"
        )
    }

    fun updateGroupMember(
        helper: DBHelperGroups,
        groupmemberid: Int,
        groupmembername: String
    ) {
        helper.readableDatabase.execSQL(
            "UPDATE groupmember " +
                    "SET " +
                    "Name = '" + groupmembername + "' " +
                    "WHERE ID = " + groupmemberid + ";"
        )
    }

    fun updateGroup(
        helper: DBHelperGroups,
        id: Int,
        groupname: String
    ) {
        helper.readableDatabase.execSQL(
            "UPDATE workergroup " +
                    "SET " +
                    "GroupName = '" + groupname + "' " +
                    "WHERE ID = " + id + ";"
        )
    }

    fun deleteGroupMemeber(helper: DBHelperGroups, groupmemberid: Int) {
        helper.readableDatabase.execSQL(
            "DELETE FROM groupmember " +
                    "WHERE ID = " + groupmemberid + ";"
        )
    }

    fun deleteGroup(helper: DBHelperGroups, id: Int) {
        helper.readableDatabase.execSQL(
            "DELETE FROM workergroup " +
                    "WHERE ID = " + id + ";"
        )
    }
}