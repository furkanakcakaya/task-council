package com.furkanakcakaya.taskcouncil.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.furkanakcakaya.taskcouncil.entity.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM Tasks")
    suspend fun getAllTasks():List<Task>

    @Insert
    suspend fun insertTask(task: Task)

    @Query("UPDATE Tasks SET task_name = :name WHERE task_id=:id")
    suspend fun updateTask(id: Int, name:String)

    @Query("DELETE FROM Tasks WHERE task_id=:id")
    suspend fun deleteTask(id:Int)

    @Query("SELECT * FROM Tasks WHERE task_name LIKE '%' || :query || '%'")
    suspend fun searchTask(query:String) : List<Task>

}