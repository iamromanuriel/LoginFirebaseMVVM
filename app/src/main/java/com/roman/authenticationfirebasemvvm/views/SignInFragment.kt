package com.roman.authenticationfirebasemvvm.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.roman.authenticationfirebasemvvm.R
import com.roman.authenticationfirebasemvvm.databinding.FragmentSignInBinding
import com.roman.authenticationfirebasemvvm.viewmodel.Authviewmodel


class SignInFragment : Fragment() {
    private var _binding : FragmentSignInBinding?= null
    private val binding get() = _binding!!
    private val viewModel : Authviewmodel by viewModels()
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getuserData().observe(this, Observer { datauser ->
            if(datauser != null){
                navController.navigate(R.id.action_signInFragment_to_signOutFragment)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.buttonSignIn.setOnClickListener {
            var emailinput = binding.editEmail.text.toString()
            var passwordinput = binding.editPassword.text.toString()
            viewModel.signIn(emailinput, passwordinput)
        }
        binding.goSignUp.setOnClickListener {
            navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }

    }


}