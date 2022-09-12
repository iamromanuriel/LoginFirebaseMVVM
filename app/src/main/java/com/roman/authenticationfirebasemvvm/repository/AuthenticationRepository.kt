package com.roman.authenticationfirebasemvvm.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository {
    private var firebaseusermutablelivedata : MutableLiveData<FirebaseUser>
    private var auth : FirebaseAuth


    constructor(){
        firebaseusermutablelivedata = MutableLiveData<FirebaseUser>()
        auth = FirebaseAuth.getInstance()
        if(auth.currentUser != null){
            firebaseusermutablelivedata.postValue(auth.currentUser)
        }

    }


    fun getfirebaseusermutablelivedata() = firebaseusermutablelivedata


    suspend fun register(email : String , password : String){
        try{
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                println("User created")
            }
        }catch (e : Exception){
            println(e.message.toString())
        }

    }

    suspend fun login (email : String , password : String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
            if(it.isSuccessful){
                firebaseusermutablelivedata.postValue(auth.currentUser)
            }
        }
    }

    suspend fun signOut(){
        auth.signOut()
    }
}