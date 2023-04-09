package com.example.motivationapp.presentation.login


import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.launch


class LoginScreenViewModel(
) : ViewModel() {
   // val loading = MutableStateFlow(LoadingState.IDLE)
    private val auth:FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    val loading: LiveData<Boolean> = _loading

    fun signInWithEmailAndPassword(email:String,password:String)
    = viewModelScope.launch{
        _loading.value = true

        try {

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {task->
                    if(task.isSuccessful){
                        Log.d("XXX","BRACKET CALLED")



                        Log.d("XXX","signInWithEmailPassword : success yay ${task.result.toString()}")
                    }else{
                        Log.d("XXX","signInWithEmailPassword : ${task.result.toString()}")
                        _loading.value = false

                    }


                }

        }catch (e:Exception){
            Log.d("TAG","signInWithEmailPassword : ${e.message}")
        }

    }
    fun signUpWithEmailAndPassword(email:String,password:String)
            = viewModelScope.launch{

        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {task->
                    if(task.isSuccessful){
                        val db = FirebaseFirestore.getInstance()
                        val user = task.result?.user
                        val Uid = auth.currentUser!!.uid

                        val userDocRef = db.collection("users").document(Uid.toString())
                        val displayName = task.result?.user?.email.toString().split('@')[0]


                        // Create a map to store the user data
                        val userData = hashMapOf(
                            "email" to email,
                            "username" to displayName,
                            "Uid" to Uid
                        )

                        // Add the user data to the document
                        userDocRef.set(userData)
                            .addOnSuccessListener {
                                Log.d(TAG, "User data added to Firestore")
                            }
                            .addOnFailureListener { e ->
                                Log.e(TAG, "Error adding user data to Firestore", e)
                            }

                        //take them home
                        Log.d("FB","signUpWithEmailPassword : success yay ${task.result.toString()}")
                    }else{
                        Log.d("FB","signUpWithEmailPassword : success yay ${task.result.toString()}")

                    }


                }

        }catch (e:Exception){
            Log.d("TAG","signInWithEmailPassword : ${e.message}")
        }

    }
}


    /*
    private fun createUser(
        displayName: String) {
        val userId = auth
        val user = MUser(
            userId = userId!!,
            displayName = displayName,
            quote = "Hello there",
            profession = "Android Developer",
            id = null).toMap()
        //Log.d("MUser", "createUser: ${user.toMap()}")
        FirebaseFirestore.getInstance().collection("users")
            .add(user)

    }

     */



