package com.ambrella.mvpexample2.presention.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ambrella.mvpexample2.R
import com.ambrella.mvpexample2.base.BaseFragment
import com.ambrella.mvpexample2.data.model.Member
import com.ambrella.mvpexample2.databinding.FragmentMemberBinding
import com.ambrella.mvpexample2.databinding.FragmentRegisterBinding
import com.ambrella.mvpexample2.presention.login.LoginContract
import com.ambrella.mvpexample2.presention.login.LoginPresenter


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(),RegisterContract.View {
    lateinit var presentr : RegisterContract.Presenter
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRegisterBinding {

        return FragmentRegisterBinding.inflate(inflater,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presentr= RegisterPresenter()
        binding.btClose.setOnClickListener { navigateTo("test",R.id.action_registerFragment_to_loginFragment) }
        binding.btRegin.setOnClickListener {

            presentr.validateRegisterFields(
                member = Member(fname = binding.etFname.text.toString(),lname = binding.etlname.text.toString(),phone = binding.etPhone.text.toString(),email = binding.etEmailAddress.text.toString(),pass = binding.etPassword.text.toString()),
                context = requireContext()
            )
            navigateTo("test",R.id.action_registerFragment_to_loginFragment)
        }
    }

    override fun showSuccessfulRegister(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    override fun navigateTo(message: String, marshrit: Int) {
        val bundle = Bundle()
        bundle.putString("title1",message)
        findNavController().navigate(marshrit,bundle)
    }


}