package com.ambrella.mvpexample2.presention.member

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ambrella.mvpexample2.data.model.Member
import com.ambrella.mvpexample2.repository.RepositoryMember
import com.ambrella.mvpexample2.repository.RepositoryMemberImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MemberPresenter:MemberContract.Presenter {
    override fun searchAccount(memb: String, context: Context):String {
        return ""
    }

    override fun deleteAccount(member: Member, context: Context) {
        val repositoryMember: RepositoryMember = RepositoryMemberImpl(context, Dispatchers.IO)

        GlobalScope.launch {   repositoryMember.delete(member)}
    }

    override fun updateAccount(member: Member, context: Context) {
        val repositoryMember: RepositoryMember = RepositoryMemberImpl(context, Dispatchers.IO)

        GlobalScope.launch {   repositoryMember.update(member)}
    }

    override fun exportlist(context: Context,string: String): MutableList<Member> {
        val repositoryMember:RepositoryMember=RepositoryMemberImpl(context, Dispatchers.Default)
        val memberList: LiveData<List<Member>> = repositoryMember.getAllCity().asLiveData()
        val res:MutableList<Member> = mutableListOf()
        memberList.observeForever { it ->
            it.forEach {

                res.add(it)
            }
        }

        return res
    }
}




