package com.example.famkart.viewmodel

import androidx.lifecycle.ViewModel
import com.example.famkart.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class AuthViewModel : ViewModel() {

    private val auth =Firebase.auth

    private val firestore= Firebase.firestore  // just a firebase db

    fun signup(email:String,name:String,password:String,onResult: (Boolean,String?)-> Unit){
          auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                   if(it.isSuccessful){
                       var userID=it.result.user?.uid
                        val userModel=UserModel(name,email,userID!!)
                       firestore.collection("users").document(userID).
                       set(userModel).addOnCompleteListener{ dbTask->
                           if(dbTask.isSuccessful){
                               onResult(true,null)
                           }else{
                               onResult(false,"Something went wrong ") }
                       }
                   }
                    else{
                        onResult(false,it.exception?.localizedMessage ?: "Something went wrong") }
          }}
    fun login(email:String,password:String,onResult: (Boolean, String?) -> Unit){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                onResult(true,null)

                }
                else{
                 onResult(false,it.exception?.localizedMessage ?: "Something went wrong")

                }


            }




}}