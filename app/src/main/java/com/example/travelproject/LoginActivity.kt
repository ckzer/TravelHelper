package com.example.travelproject

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelproject.databinding.ActivityLoginBinding
import com.example.travelproject.databinding.FragmentSettingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var auth : FirebaseAuth
private var firebaseAuth: FirebaseAuth? = null

private const val RC_SIGN_IN = 9001

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = Firebase.auth;

        // 로그인 버튼
        binding.btnLogin.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()

            login(email, password)  // 로그인 함수
        }

        // 회원가입 버튼
        binding.btnSignup.setOnClickListener {
            // 회원가입 activity 이동 객체 생성
            val intent: Intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)   // 회원가입(signupActivity로)
        }
    }

    // 로그인 함수
    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent: Intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "로그인 실패....", Toast.LENGTH_SHORT).show()
                    Log.d("Login", "Error : ${task.exception}")
                }
            }
    }
}