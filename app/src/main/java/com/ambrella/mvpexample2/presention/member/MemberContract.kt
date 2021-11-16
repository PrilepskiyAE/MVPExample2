package com.ambrella.mvpexample2.presention.member

interface MemberContract {
    interface View{
        fun loadUserDetail(message:String)
        fun showSuccess(message:String)
        fun navigateToNextPage()
        fun refreshPage(message:String)
        fun logOut()
    }
    interface Presenter{
        fun getUserEmail(message:String)
        fun logOut(message:String)
        fun getUserDetail(message:String)
        fun deleteAccount(message:String)
        fun validateUpdateFields(message:String):Boolean
    }

}