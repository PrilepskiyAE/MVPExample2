package com.ambrella.mvpexample2.data.db

import androidx.room.*
import com.ambrella.mvpexample2.data.model.Member
import kotlinx.coroutines.flow.Flow


@Dao
interface DAOmember {
    @Query("SELECT * from table_member")

    fun getMember(): Flow<List<Member>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(member: Member)

    @Query("DELETE FROM table_member")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(member: Member): Int
}