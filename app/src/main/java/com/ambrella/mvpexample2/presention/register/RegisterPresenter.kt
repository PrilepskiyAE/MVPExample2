package com.ambrella.mvpexample2.presention.register
import androidx.lifecycle.*
import android.content.Context
import com.ambrella.mvpexample2.data.model.Member
import com.ambrella.mvpexample2.repository.RepositoryMember
import com.ambrella.mvpexample2.repository.RepositoryMemberImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterPresenter:RegisterContract.Presenter {


    override  fun validateRegisterFields(member: Member, context: Context) {

        val repositoryMember: RepositoryMember = RepositoryMemberImpl(context, Dispatchers.IO)

        GlobalScope.launch {   repositoryMember.insert(member)}

    }
}