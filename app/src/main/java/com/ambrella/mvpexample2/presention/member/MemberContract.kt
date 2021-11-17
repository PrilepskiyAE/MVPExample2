package com.ambrella.mvpexample2.presention.member

import android.content.Context
import com.ambrella.mvpexample2.data.model.Member

interface MemberContract {
    interface View{

        fun updateClick()
        fun logOutClick()
    }
    interface Presenter{
        fun searchAccount(member: String, context: Context):String
        fun deleteAccount(member: Member, context: Context)
        fun updateAccount(member: Member, context: Context)
        fun exportlist(context: Context,string: String):MutableList<Member>
    }

}