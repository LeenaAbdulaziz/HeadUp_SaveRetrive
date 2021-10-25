package com.example.headup_saveretrive

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlpr(context: Context):SQLiteOpenHelper(context,"details",null,1) {
    var database:SQLiteDatabase=writableDatabase
    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL("create table celebebrity(_id integer primary key autoincrement,name text,taboo1 text,taboo2 text,taboo3 text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addcelebrity(name:String,taboo1:String,taboo2:String,taboo3:String,){
        var content=ContentValues()
        content.put("name",name)
        content.put("taboo1",taboo1)
        content.put("taboo2",taboo2)
        content.put("taboo3",taboo3)
        database.insert("celebebrity",null,content)
    }

    @SuppressLint("Range")
    fun viewceleb():ArrayList<Celebrity>{
        var noteList= arrayListOf<Celebrity>()
        var c: Cursor =database.query("celebebrity",null,null,
            null,null,null,null)

        c.moveToFirst()
        var name:String
        var taboo1:String
        var taboo2:String
        var taboo3:String
       if(c.moveToFirst()){
           do{

           name =c.getString(c.getColumnIndex("name"))
           taboo1 =c.getString(c.getColumnIndex("taboo1"))
           taboo2 =c.getString(c.getColumnIndex("taboo2"))
           taboo3 =c.getString(c.getColumnIndex("taboo3"))
               val celeb=Celebrity(name, taboo1, taboo2, taboo3)
            noteList.add(celeb)

        }while(c.moveToNext())
       }
        return noteList
    }
    }
