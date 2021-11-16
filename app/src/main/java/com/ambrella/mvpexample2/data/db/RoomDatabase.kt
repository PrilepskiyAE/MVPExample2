package com.ambrella.mvpexample2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ambrella.mvpexample2.data.model.Member
import kotlinx.coroutines.CoroutineDispatcher

@Database(entities = arrayOf(Member::class), version = 1, exportSchema = false)
abstract class RoomDatabaseMember : RoomDatabase() {
    abstract fun daomember(): DAOmember

    companion object {
        private var INSTANCE: RoomDatabaseMember? = null
        fun getInstance(
            context: Context,
            backgroundDispatcher: CoroutineDispatcher
        ): RoomDatabaseMember? {
            if (INSTANCE == null) {
                synchronized(RoomDatabaseMember::class)
                {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        RoomDatabaseMember::class.java, "Member_database"
                    ).build()
                }
            }
            return INSTANCE
        }


    }

}