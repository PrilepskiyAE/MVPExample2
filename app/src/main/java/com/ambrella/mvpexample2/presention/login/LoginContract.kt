package com.ambrella.mvpexample2.presention.login

import android.content.Context
import com.ambrella.mvpexample2.data.model.Member

interface LoginContract {
    interface View{
        fun showSuccessfulMessage(message:String)
        fun navigateTo(mail:String,marshrit:Int)
    }
    interface Presenter{
        fun validateLoginFields(members:MutableList<Member>,email:String):Boolean
        fun exportlist(context: Context):MutableList<Member>
    }
}