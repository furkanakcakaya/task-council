package com.furkanakcakaya.taskcouncil.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName = "Tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "task_id") @NotNull var task_id: Int,

    @ColumnInfo(name = "task_name") @NotNull var task_name: String
): Serializable