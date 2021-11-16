package com.ambrella.mvpexample2.repository

import com.ambrella.mvpexample2.data.model.Member
import kotlinx.coroutines.flow.Flow

interface RepositoryMember {
    fun getAllCity(): Flow<List<Member>>
    suspend fun insert(member: Member)
    suspend fun deleteAll()
    suspend fun delete(member: Member)
}