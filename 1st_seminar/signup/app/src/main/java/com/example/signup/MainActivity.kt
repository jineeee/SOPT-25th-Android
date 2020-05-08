package com.example.signup


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_SIGNUP_ACTIVITY = 7777

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtSignInId: EditText = findViewById(R.id.edtSignInId)
        val edtSignInPw: EditText = findViewById(R.id.edtSignInPw)
        val btnSignInLogin: Button = findViewById(R.id.btnSignInLogin)
        val btnSignInSignUp: Button = findViewById(R.id.btnSignInSignUp)

        btnSignInSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_SIGNUP_ACTIVITY)
        }

        btnSignInLogin.setOnClickListener{

            val id = edtSignInId.text.toString()
            val pw = edtSignInPw.text.toString()

            if (id.isEmpty() || pw.isEmpty()) {
                // 사용자에게 간단한 text 정보를 알려주기 위해 Toast를 띄워준다.
                Toast.makeText(this, "아이디나 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_SIGNUP_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                val signUpId = data!!.getStringExtra("id")
                edtSignInId.setText(signUpId)
                val signUpPw = data!!.getStringExtra("pw")
                edtSignInPw.setText(signUpPw)
            }
        }
    }

}
