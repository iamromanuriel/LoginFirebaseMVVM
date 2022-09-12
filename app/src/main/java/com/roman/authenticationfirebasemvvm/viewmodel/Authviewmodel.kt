package com.roman.authenticationfirebasemvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roman.authenticationfirebasemvvm.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Authviewmodel() : ViewModel(){
    private var repository = AuthenticationRepository()
    private var userData = repository.getfirebaseusermutablelivedata()

    fun getuserData() = userData


    fun register(email : String , password : String) = viewModelScope.launch(Dispatchers.IO){
        try{
            repository.register(email, password)
        }catch(e : Exception){
            println(e.message)
        }

    }

    fun signIn (email : String, password: String) = viewModelScope.launch(Dispatchers.IO){
        try{
            repository.login(email, password)
        }catch(e : Exception){
            println(e.message)
        }

    }
    fun signout() = viewModelScope.launch(Dispatchers.IO){
        repository.signOut()
    }
}