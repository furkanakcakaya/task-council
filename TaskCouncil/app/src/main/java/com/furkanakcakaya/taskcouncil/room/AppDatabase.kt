package com.furkanakcakaya.taskcouncil.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.furkanakcakaya.taskcouncil.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun taskDao() : TaskDao
    companion object{
        private var instance: AppDatabase? = null
        fun getInstance(context: Context) : AppDatabase{
            if (instance == null){
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "todo.sqlite")
                        .createFromAsset("todo.sqlite")
                        .build()
                }
            }
            return instance!!
        }
    }
}