package com.example.loginregistration.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.loginregistration.model.User
import com.example.loginregistration.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.android.gms.tasks.OnCompleteListener

class AuthViewModel(
    var navController: NavHostController,
    var context: Context
){
    var mAuth: FirebaseAuth= FirebaseAuth.getInstance()
    fun signup(fname: String,lname: String,email: String,pass: String){
        if (fname.isEmpty()&&lname.isEmpty()&&email.isEmpty()&&pass.isEmpty())
        {
            Toast.makeText(context,"PLEASE FILL IN ALL DETAILS",
                Toast.LENGTH_LONG    ).show()

        }else{
            mAuth.create(email,pass)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        val userData= User(fname,lname,email,pass)
                            .addOnCompleteListener{
                                if (it.isSuccessful){
                                    val userData= User(fname,lname,email,pass,mAuth.currentUser!!.uid)
                                    val  regRef=FirebaseDatabase.getInstance().getReference().child("Users/"+mAuth.currentUser!!.uid)
                                    regRef.setValue(userData)
                                        .addOnCompleteLi
                                            if(it.isSuccessful){
                                                Toast.makeText(context,"YOU'VE SUCCESSFULLY CREATED AN ACCOUNT",
                                                    Toast.LENGTH_LONG).show()
                                            }else{
                                                Toast.makeText(context,"YOU'VE FAILED TO CREATE AN ACCOUNT",
                                                    Toast.LENGTH_LONG)
                                                    .show()
                                                navController.navigate(ROUTE_REGISTER)
                                            }
                                        }
                                }else{
                                    navController.navigate(ROUTE_REGISTER)
                                }

                            }
                    }
                }
        }
        fun login(
            email: String,
            pass: String
        ){
            mAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener {  }
        }
    }

}