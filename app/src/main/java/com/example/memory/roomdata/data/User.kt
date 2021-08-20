package com.example.memory.roomdata.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author user
 * @date 20.08.2021
 */

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
)