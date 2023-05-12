package com.example.workweekmanagement.model

class Tasks(
    val workerID: Int,
    val workername: String,
    val workerpassword: String,
    val workeremail: String,
    val workerstrength: Int,
    val taskID: Int,
    val name: String,
    val creator: String,
    val tasktitle: String,
    val taskstart: String,
    val taskend: String,
    val comment: String,
    val finished: String,
    val closed: Int)
{}