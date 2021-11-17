package com.ambrella.mvpexample2.presention.member

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ambrella.mvpexample2.R
import com.ambrella.mvpexample2.base.BaseFragment
import com.ambrella.mvpexample2.data.model.Member
import com.ambrella.mvpexample2.databinding.FragmentMemberBinding
import com.ambrella.mvpexample2.presention.login.LoginPresenter


class MemberFragment : BaseFragment<FragmentMemberBinding>(),MemberContract.View {
lateinit var presentr:MemberContract.Presenter
 var member:MutableList<Member> = mutableListOf()
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMemberBinding {
        return FragmentMemberBinding.inflate(inflater,container,false)
    }

    override fun onStart() {
        super.onStart()

        presentr= MemberPresenter()
        member= presentr.exportlist(requireContext(), requireArguments().getString("title1")!!
        )
        Log.d("test22",member.toString())
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      // val m= requireArguments().getString("title1")

        Log.d("test22",member.toString())
        Log.d("tttt", requireArguments().getString("title1")!!)


       //member = presentr.searchAccount(m!!,requireContext())
       // binding.textView2.text=member
    }

    override fun updateClick() {
        TODO("Not yet implemented")
    }

    override fun logOutClick() {
        TODO("Not yet implemented")
    }


}