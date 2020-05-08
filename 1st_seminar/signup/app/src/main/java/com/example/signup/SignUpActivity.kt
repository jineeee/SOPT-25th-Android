package com.example.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    val TAG: String = "signupAct"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val edtSignUpName: EditText = findViewById(R.id.edtSignUpName)
        val edtSignUpId: EditText = findViewById(R.id.edtSignUpId)
        val edtSignUpPw: EditText = findViewById(R.id.edtSignUpPw)
        val edtSignUpPwCheck: EditText = findViewById(R.id.edtSignUpPwCheck)
        val btnSignUpSignUp: Button = findViewById(R.id.btnSignUp)

        btnSignUpSignUp.setOnClickListener {
            Log.e(TAG + "pw" , "pw : "+edtSignUpPw.text.toString()+" check : "+edtSignUpPwCheck.text.toString())
            if(pwCheck(edtSignUpPw.text.toString(),edtSignUpPwCheck.text.toString())){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", edtSignUpId.text.toString())
                intent.putExtra("pw", edtSignUpPw.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }

    fun pwCheck(pw : String, pwCheck : String) : Boolean {
        if(pw == pwCheck){
            return true
        }else {
            return false
        }
    }
}
