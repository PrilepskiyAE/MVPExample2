package com.ambrella.mvpexample2.repository

import android.content.Context
import com.ambrella.mvpexample2.data.db.DAOmember
import com.ambrella.mvpexample2.data.db.RoomDatabaseMember
import com.ambrella.mvpexample2.data.model.Member
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RepositoryMemberImpl(context: Context, private val backgroundDispatcher: CoroutineDispatcher):RepositoryMember {
    private val memberDao: DAOmember
    init {
        val database=RoomDatabaseMember.getInstance(context,backgroundDispatcher)
        if (database != null) {
            memberDao=database.daomember()
        }else
        {
            throw NullPointerException("MyDatabase critical EROOOR")
        }
    }
    override fun getAllCity(): Flow<List<Member>> {
        return memberDao.getMember()
    }

    override suspend fun insert(member: Member) {
        withContext(backgroundDispatcher)
        {
            memberDao.insert(member)
        }
    }

    override suspend fun deleteAll() {
        withContext(backgroundDispatcher){
            memberDao.deleteAll()
        }
    }

    override suspend fun delete(member: Member) {
        withContext(backgroundDispatcher){
            memberDao.delete(member)
        }
    }
}