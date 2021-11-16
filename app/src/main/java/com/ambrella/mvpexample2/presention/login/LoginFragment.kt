package com.ambrella.mvpexample2.presention.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ambrella.mvpexample2.R
import com.ambrella.mvpexample2.base.BaseFragment
import com.ambrella.mvpexample2.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding>(),LoginContract.View {

lateinit var presentr : LoginContract.Presenter
lateinit var loginPresenter: LoginPresenter




    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
       return FragmentLoginBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presentr=LoginPresenter()

        binding.button2.setOnClickListener {
            Log.i("tag111","okrrrr")
            if (presentr.validateLoginFields(requireContext(),binding.editTextTextPersonName.text.toString())){
                Log.i("tag111","okrrrr")
                showSuccessfulMessage("LOGIN")
                navigateTo("test",R.id.action_loginFragment_to_memberFragment)
            }else
            {
                showSuccessfulMessage("ERROR")
                Log.i("tag111","onrrrr")
            }
             }
        binding.button.setOnClickListener { navigateTo("test2",R.id.action_loginFragment_to_registerFragment) }
    }

    override fun showSuccessfulMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }


    override fun navigateTo(mail: String, marshrit: Int) {
        val bundle = Bundle()
        bundle.putString("title1", mail)
        //findNavController().navigate(R.id.action_loginFragment_to_memberFragment)
        findNavController().navigate(marshrit,bundle)
    }
}