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
     var result:Boolean=false
    override fun validateLoginFields(context: Context,email:String): Boolean {

        val repositoryMember:RepositoryMember=RepositoryMemberImpl(context, Dispatchers.IO)
        val memberList: LiveData<List<Member>> = repositoryMember.getAllCity().asLiveData()
        memberList.observeForever { it ->
            it.forEach {
                result  = if(email.equals(it.fname)) true else false
                //result  = if(email.equals("test")) true else false
            }
        }

        return result
    }
}