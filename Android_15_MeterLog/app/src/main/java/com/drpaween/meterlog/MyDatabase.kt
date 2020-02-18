package com.drpaween.meterlog

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
var sql="""create table waterdata(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    meter_id INTEGER,
    meter_value REAL,
    timestamp datetime default current_timestamp);    
""".trimIndent()
     db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) { }
}