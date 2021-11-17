package com.ambrella.mvpexample2.presention.login

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.ambrella.mvpexample2.data.model.Member
import com.ambrella.mvpexample2.repository.RepositoryMember
import com.ambrella.mvpexample2.repository.RepositoryMemberImpl
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlin.properties.Delegates

class LoginPresenter():LoginContract.Presenter {



    override fun validateLoginFields(members: MutableList<Member>, name: String,pass:String): Boolean {
        var result:Boolean=false
        for (i in members)
        {
            result  = if(name.equals(i.fname)&&pass.equals(i.pass))  true else false
        }
        return result
    }

    override fun exportlist(context: Context): MutableList<Member> {

        val repositoryMember:RepositoryMember=RepositoryMemberImpl(context, Dispatchers.IO)
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