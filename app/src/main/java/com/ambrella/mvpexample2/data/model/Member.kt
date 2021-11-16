package com.ambrella.mvpexample2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "table_member")
data class Member(
    @PrimaryKey(autoGenerate = true) var id:Int=0,
    val fname:String,
    val lname:String,
    val phone:String,
    val email:String,
    val pass:String)
