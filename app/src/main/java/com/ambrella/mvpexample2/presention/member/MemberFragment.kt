package com.ambrella.mvpexample2.presention.member

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ambrella.mvpexample2.R
import com.ambrella.mvpexample2.base.BaseFragment
import com.ambrella.mvpexample2.data.model.Member
import com.ambrella.mvpexample2.databinding.FragmentMemberBinding


class MemberFragment : BaseFragment<FragmentMemberBinding>(),MemberContract.View {
var presentr:MemberContract.Presenter=MemberPresenter()

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMemberBinding {
        return FragmentMemberBinding.inflate(inflater,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //presentr= MemberPresenter()
       val member= presentr.exportlist(requireContext(), requireArguments().getString("title1")!!
        )
        Log.d("test22",member.toString())
        binding.textView2.text="Здравствуйте Уважаемый ${member.last().lname} \n ${member.last().fname} \n ${member.last().email}  "
        binding.btDelete.setOnClickListener { deleteOnClick(member.last()) }
        binding.btExit.setOnClickListener { logOutClick() }
        binding.btUpdate.setOnClickListener { deleteOnClick(member.last()) }
    }

    override fun updateClick(member: Member) {
        presentr.updateAccount(member,requireContext())
        findNavController().navigate(R.id.action_memberFragment_to_loginFragment)


    }

    override fun logOutClick() {
        findNavController().navigate(R.id.action_memberFragment_to_loginFragment)

    }

    override fun deleteOnClick(member: Member) {

        presentr.deleteAccount(member,requireContext())
        findNavController().navigate(R.id.action_memberFragment_to_loginFragment)
    }


}