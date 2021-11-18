package com.ambrella.mvpexample2.presention.member

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ambrella.mvpexample2.R
import com.ambrella.mvpexample2.base.BaseFragment
import com.ambrella.mvpexample2.data.model.Member
import com.ambrella.mvpexample2.databinding.FragmentMemberBinding
import java.util.*


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
        binding.textView2.text=
            "Здравствуйте Уважаемый ${member.last().lname} \n ${member.last().fname} \n ${member.last().email}  "
        binding.btDelete.setOnClickListener { deleteOnClick(member.last()) }
        binding.btExit.setOnClickListener { logOutClick() }
        binding.btUpdate.setOnClickListener {

            updateClick(member.last())
        }
    }

    override fun updateClick(member: Member) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_update)
        dialog.findViewById<Button>(R.id.bt_update1).setOnClickListener {
            val fname:String=dialog.findViewById<EditText>(R.id.et_username).text.toString()
            val lname:String=dialog.findViewById<EditText>(R.id.et_Lname1).text.toString()
            val email:String=dialog.findViewById<EditText>(R.id.et_EmailAddress1).text.toString()
            val pass:String=dialog.findViewById<EditText>(R.id.et_password1).text.toString()
            val phone:String=dialog.findViewById<EditText>(R.id.et_Phone1).text.toString()
            if(!fname.equals("") && !lname.equals("") && !email.equals("") && !pass.equals("") && !phone.equals("")){

            presentr.updateAccount(Member(
                member.id,
                fname = fname,
                lname = lname,
                email = email,
                pass = pass,
                phone = phone),
                requireContext())
                Toast.makeText(activity, "Пользовательские данные успешно изменены", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_memberFragment_to_loginFragment)
                dialog.cancel()
            }
           else  Toast.makeText(activity, "Заполните все поля", Toast.LENGTH_SHORT).show();
        }



        Objects.requireNonNull<Window>(dialog.window).setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        //



    }

    override fun logOutClick() {
        findNavController().navigate(R.id.action_memberFragment_to_loginFragment)

    }

    override fun deleteOnClick(member: Member) {

        presentr.deleteAccount(member,requireContext())
        findNavController().navigate(R.id.action_memberFragment_to_loginFragment)
    }


}