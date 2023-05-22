package com.example.workweekmanagement.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelperMain(context: Context) : SQLiteOpenHelper(context, "WORKDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE self(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT, " +
                    "Password TEXT, " +
                    "Email TEXT, " +
                    "Strength TEXT)"
        )

        db?.execSQL(
            "INSERT INTO self(NAME, Password, Email, Strength) " +
                    "VALUES('Minta János','e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'minta.janos@gmail.com', 0)"
        )


        db?.execSQL(
            "CREATE TABLE groupmember(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "GroupName TEXT, " +
                    "Name TEXT)"
        )

        db?.execSQL(
            "INSERT INTO groupmember (GroupName, Name) VALUES" +
                    "('HeadAdmin', 'Minta János')," +
                    "('Admin', 'Szabó Irén')," +
                    "('Fejlesztő', 'Minta János')," +
                    "('Fejlesztő', 'Szabó Irén')," +
                    "('Fejlesztő', 'Gipsz Jakab')," +
                    "('Fejlesztő', 'Minta Jónás')," +
                    "('Fejlesztő', 'Kovács István')," +
                    "('Fejlesztő', 'Miskolci Gergely')," +
                    "('Fejlesztő', 'Gipsz Jakabné')," +
                    "('Fejlesztő', 'Boros Péter')," +
                    "('Fejlesztő', 'Fekete Péter')," +
                    "('Fejlesztő', 'Egerszegi Bernadett');"
        )

        db?.execSQL(
            "CREATE TABLE task(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT, " +
                    "Creator TEXT, " +
                    "TaskTitle TEXT, " +
                    "TimeStart TEXT, " +
                    "TimeEnd TEXT, " +
                    "Comment TEXT, " +
                    "Finished TEXT, " +
                    "Closed INTEGER)"
        )

        db?.execSQL(
            "INSERT INTO task (Name, Creator, TaskTitle, TimeStart, TimeEnd, Comment, Finished, Closed) VALUES" +
                    "('Minta János', 'Minta János', 'Dolgozok ellenörzése', '2020-01-01 08:00:00', '2050-01-01 16:00:00', 'Napi feladat', 'folyamatban', 0)," +
                    "('Szabó Irén', 'Minta János', 'Admin tevékenység', '2020-01-01 08:00:00', '2030-01-01 16:00:00', '', 'folyamatban', 0)," +
                    "('Szabó Irén', 'Minta János', 'Szerver frissités', '2023-03-01 08:00:00', '2023-03-01 16:00:00', 'Szerver frissités beütemezése', 'folyamatban', 0)," +
                    "('Gipsz Jakab', 'Minta János', 'Gépterem kitakarítása', '2023-03-01 08:00:00', '2023-03-01 16:00:00', 'Gépterem raktárnak van használva', 'mai feladat', 0)," +
                    "('Minta Jónás', 'Minta János', 'Dolgozok ellenörzése', '2020-01-01 08:00:00', '2030-01-01 16:00:00', 'Ha nem nézel rájuk akkor nem megy a munka', 'folyatban', 0)," +
                    "('Minta Jónás', 'Minta Jónás', 'Feladatok kiosztása', '2020-01-01 08:00:00', '2030-01-01 16:00:00', '', 'folyatban', 0)," +
                    "('Kovács István', 'Minta Jónás', 'Minta Jónás számítógépének újratelepítése', '2023-03-01 08:00:00', '2023-03-01 16:00:00', '', 'mai feladat', 0)," +
                    "('Miskolci Gergely', 'Minta János', 'Weblaphoz CRUD fejlesztés', '2023-03-01 08:00:00', '2023-03-11 16:00:00', '', 'folyamatban', 0)," +
                    "('Gipsz Jakabné', 'Minta Jónás', 'Weblap táblák létrehozása', '2023-03-01 08:00:00', '2023-03-05 16:00:00', '', 'folyamatban', 0)," +
                    "('Boros Péter', 'Minta János', 'Weblap React fejlesztés', '2023-03-01 08:00:00', '2023-04-01 16:00:00', '', 'folyamatban', 0);"
        )

        db?.execSQL(
            "CREATE TABLE worker(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT, " +
                    "Password TEXT, " +
                    "Email TEXT, " +
                    "Strength INTEGER)"
        )

        db?.execSQL(
            "INSERT INTO worker (ID, Name, Password, Email, Strength) VALUES" +
                    "(0, 'Minta János', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'minta.janos@gmail.com', 0)," +
                    "(1, 'Szabó Irén', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'szabo.iran@akarmi.com', 0)," +
                    "(2, 'Gipsz Jakab', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'gipsz.jakab@akarmi.com', 2)," +
                    "(3, 'Minta Jónás', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'minta.jonas@akarmi.com', 1)," +
                    "(4, 'Kovács István', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'kovacs.istvan@akarmi.com', 2)," +
                    "(5, 'Miskolci Gergely', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'miskolci.gergely@akarmi.com', 2)," +
                    "(6, 'Gipsz Jakabné', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'gipsz.jakabne@akarmi.com', 2)," +
                    "(7, 'Boros Péter', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'boros.peter@akarmi.com', 2)," +
                    "(8, 'Fekete Péter', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'fekete.peter@akarmi.com', 2)," +
                    "(9, 'Egerszegi Bernadett', 'e1b27b9afb0a8e77e5b8071c4eb01c49843fe631cb7008249071f1993a2baccf', 'egerszegi.bernadett@akarmi.com', 2);"
        )

        db?.execSQL(
            "CREATE TABLE workergroup(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "GroupName TEXT)"
        )

        db?.execSQL(
            "INSERT INTO workergroup (GroupName) VALUES" +
                    "('HeadAdmin')," +
                    "('Admin')," +
                    "('Fejlesztő');"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}