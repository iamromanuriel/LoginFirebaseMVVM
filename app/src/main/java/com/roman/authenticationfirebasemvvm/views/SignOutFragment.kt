package com.roman.authenticationfirebasemvvm.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.roman.authenticationfirebasemvvm.R
import com.roman.authenticationfirebasemvvm.databinding.FragmentSignOutBinding
import com.roman.authenticationfirebasemvvm.viewmodel.Authviewmodel


class SignOutFragment : Fragment() {

    private var _binding : FragmentSignOutBinding?= null
    private val binding get() = _binding!!
    private val viewModel : Authviewmodel by viewModels()
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getuserData().observe(this, Observer {
            if(it != null){
                binding.showemail.text =it.email
            }else{
                binding.btnSignOut.visibility = View.GONE
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignOutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.btnSignOut.setOnClickListener {
            viewModel.signout()
            navController.navigate(R.id.action_signOutFragment_to_signInFragment)
        }
    }


}