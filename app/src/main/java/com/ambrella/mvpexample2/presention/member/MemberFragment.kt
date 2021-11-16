package com.ambrella.mvpexample2.presention.member

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ambrella.mvpexample2.R
import com.ambrella.mvpexample2.base.BaseFragment
import com.ambrella.mvpexample2.databinding.FragmentMemberBinding


class MemberFragment : BaseFragment<FragmentMemberBinding>(),MemberContract.View {

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMemberBinding {
        return FragmentMemberBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun loadUserDetail(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    override fun navigateToNextPage() {
        TODO("Not yet implemented")
    }

    override fun refreshPage(message: String) {
        TODO("Not yet implemented")
    }

    override fun logOut() {
        TODO("Not yet implemented")
    }


}