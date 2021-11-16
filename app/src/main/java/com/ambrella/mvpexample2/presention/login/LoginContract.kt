package com.ambrella.mvpexample2.presention.login

import android.content.Context

interface LoginContract {
    interface View{
        fun showSuccessfulMessage(message:String)
        fun navigateTo(mail:String,marshrit:Int)
    }
    interface Presenter{
        fun validateLoginFields(context: Context,email:String):Boolean
    }
}