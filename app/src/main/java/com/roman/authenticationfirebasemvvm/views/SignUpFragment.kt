package com.roman.authenticationfirebasemvvm.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.roman.authenticationfirebasemvvm.R
import com.roman.authenticationfirebasemvvm.databinding.FragmentSignInBinding
import com.roman.authenticationfirebasemvvm.databinding.FragmentSignUpBinding
import com.roman.authenticationfirebasemvvm.viewmodel.Authviewmodel

class SignUpFragment : Fragment() {
    private var _binding : FragmentSignUpBinding?= null
    private val binding get() = _binding!!
    private val viewModel : Authviewmodel by viewModels()
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.buttonSignUp.setOnClickListener {
            var emailtext = binding.editEmail.text.toString()
            var passwordtext = binding.editPassword.text.toString()
            viewModel.register(emailtext,passwordtext)
        }
        binding.goSignUp.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }


}