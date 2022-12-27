package com.example.travelproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelproject.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

private lateinit var auth : FirebaseAuth
private var firebaseAuth: FirebaseAuth? = null

private const val RC_SIGN_IN = 9001

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    lateinit var mAuth: FirebaseAuth

    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증 초기화
        mAuth  = Firebase.auth

        // 데이터베이스 초기화
        mDbRef = Firebase.database.reference

        binding.btnSignup.setOnClickListener {
            val name = binding.txtName.text.toString().trim()
            val email = binding.txtEmail.text.toString().trim()
            val password = binding.txtPassword.text.toString().trim()

            signUp(name, email, password)
        }
    }

    // 회원가입~!
    private fun signUp(name: String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "회원가입 성공하셨습니다~", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)
                    addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
                } else {
                    Toast.makeText(this, "회원가입 실패하셨습니다....", Toast.LENGTH_SHORT).show()
                    Log.d("SignUp", "Error: ${task.exception}")
                }
            }
    }

    private fun addUserToDatabase(name: String, email: String, uId: String) {
        mDbRef.child("user").child(uId).setValue(User(name,email,uId))
    }
}
