package com.ambrella.mvpexample2.presention.register

import android.content.Context
import com.ambrella.mvpexample2.data.model.Member

interface RegisterContract {
    interface View{
        fun showSuccessfulRegister(message:String)
        fun navigateTo(message:String,marshrit:Int)
    }
    interface Presenter{
        fun validateRegisterFields(member: Member,context: Context)

    }
}