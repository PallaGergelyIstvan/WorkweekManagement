package com.example.workweekmanagement.data


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelperMain(context: Context): SQLiteOpenHelper(context,"WORKDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE SELF(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "EMAIL TEXT, " +
                "TASK TEXT, " +
                "TIME TEXT, " +
                "COMMA TEXT)")

        db?.execSQL("INSERT INTO SELF(NAME, EMAIL, TASK, TIME,COMMA) " +
                "VALUES('sadaa','asd@gmail.com','asd','sad','sad')")
        db?.execSQL("INSERT INTO SELF(NAME, EMAIL, TASK, TIME,COMMA) " +
                "VALUES('sad','asd@gmail.com','asd','sad','sad')")
        db?.execSQL("INSERT INTO SELF(NAME, EMAIL, TASK, TIME,COMMA) " +
                "VALUES('asd','asd@gmail.com','asd','asd','sad')")
        db?.execSQL("INSERT INTO SELF(NAME, EMAIL, TASK, TIME,COMMA) " +
                "VALUES('asd','asd@gmail.com','asd','asd','sad')")

        db?.execSQL("CREATE TABLE groupmember(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "GroupID INTEGER, " +
                "NameID INTEGER)")

        db?.execSQL("INSERT INTO groupmember (ID, GroupID, NameID) VALUES" +
                "(0, 0, 0)," +
                "(1, 1, 1)," +
                "(2, 2, 0)," +
                "(3, 2, 1)," +
                "(4, 2, 2)," +
                "(5, 2, 3)," +
                "(6, 2, 4)," +
                "(7, 2, 5)," +
                "(8, 2, 6)," +
                "(9, 2, 7)," +
                "(10, 2, 8)," +
                "(11, 2, 9);")

        db?.execSQL("CREATE TABLE task(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Creator TEXT, " +
                "TaskTitle TEXT, " +
                "TimeStart TEXT, " +
                "TimeEnd TEXT, " +
                "Comment TEXT, " +
                "Finished TEXT, " +
                "Closed INTEGER)")

        db?.execSQL("INSERT INTO task (Name, Creator, TaskTitle, TimeStart, TimeEnd, Comment, Finished, Closed) VALUES" +
                "('Minta János', 'Minta János', 'Dolgozok ellenörzése', '2020-01-01 08:00:00', '2050-01-01 16:00:00', 'Napi feladat', 'folyamatban', 0)," +
                "('Szabó Irén', 'Minta János', 'Admin tevékenység', '2020-01-01 08:00:00', '2030-01-01 16:00:00', '', 'folyamatban', 0)," +
                "('Szabó Irén', 'Minta János', 'Szerver frissités', '2023-03-01 08:00:00', '2023-03-01 16:00:00', 'Szerver frissités beütemezése', 'folyamatban', 0)," +
                "('Gipsz Jakab', 'Minta János', 'Gépterem kitakarítása', '2023-03-01 08:00:00', '2023-03-01 16:00:00', 'Gépterem raktárnak van használva', 'mai feladat', 0)," +
                "('Minta Jónás', 'Minta János', 'Dolgozok ellenörzése', '2020-01-01 08:00:00', '2030-01-01 16:00:00', 'Ha nem nézel rájuk akkor nem megy a munka', 'folyatban', 0)," +
                "('Minta Jónás', 'Minta Jónás', 'Feladatok kiosztása', '2020-01-01 08:00:00', '2030-01-01 16:00:00', '', 'folyatban', 0)," +
                "('Kovács István', 'Minta Jónás', 'Minta Jónás számítógépének újratelepítése', '2023-03-01 08:00:00', '2023-03-01 16:00:00', '', 'mai feladat', 0)," +
                "('Miskolci Gergely', 'Minta János', 'Weblaphoz CRUD fejlesztés', '2023-03-01 08:00:00', '2023-03-11 16:00:00', '', 'folyamatban', 0)," +
                "('Gipsz Jakabné', 'Minta Jónás', 'Weblap táblák létrehozása', '2023-03-01 08:00:00', '2023-03-05 16:00:00', '', 'folyamatban', 0)," +
                "('Boros Péter', 'Minta János', 'Weblap React fejlesztés', '2023-03-01 08:00:00', '2023-04-01 16:00:00', '', 'folyamatban', 0);")

        db?.execSQL("CREATE TABLE worker(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Password TEXT, " +
                "Email TEXT, " +
                "Strength INTEGER)")

        db?.execSQL("INSERT INTO worker (ID, Name, Password, Email, Strength) VALUES" +
                "(0, 'Minta János', '12345678', 'minta.janos@gmail.com', 0)," +
                "(1, 'Szabó Irén', '12345678', 'szabo.iran@akarmi.com', 0)," +
                "(2, 'Gipsz Jakab', '12345678', 'gipsz.jakab@akarmi.com', 2)," +
                "(3, 'Minta Jónás', '12345678', 'minta.jonas@akarmi.com', 1)," +
                "(4, 'Kovács István', '12345678', 'kovacs.istvan@akarmi.com', 2)," +
                "(5, 'Miskolci Gergely', '12345678', 'miskolci.gergely@akarmi.com', 2)," +
                "(6, 'Gipsz Jakabné', '12345678', 'gipsz.jakabne@akarmi.com', 2)," +
                "(7, 'Boros Péter', '12345678', 'boros.peter@akarmi.com', 2)," +
                "(8, 'Fekete Péter', '12345678', 'fekete.peter@akarmi.com', 2)," +
                "(9, 'Egerszegi Bernadett', '12345678', 'egerszegi.bernadett@akarmi.com', 2);")

        db?.execSQL("CREATE TABLE workergroup(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "GroupName TEXT)")

        db?.execSQL("INSERT INTO workergroup (ID, GroupName) VALUES" +
                "(0, 'HeadAdmin')," +
                "(1, 'Admin')," +
                "(2, 'Fejlesztő');")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}