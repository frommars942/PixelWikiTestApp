package com.testing.pixelwikiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.testing.pixelwikiapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // pixelize bg1
        binding.bg1.background.isFilterBitmap = false
        binding.loginButton.drawable.isFilterBitmap = false

        // call to our cheap copy of real database
        binding.loginButton.setOnClickListener {

            // Just debug log.i in console
            Log.i("button_touch", "BUTTON TOUCH HERE!")

            // We store here email and password input from player for later check in our mini-database ->>>
            val emailField = binding.email.text.toString().trim()
            val passwordField = binding.password.text.toString().trim()

            // Initialize new exemplar of repository and call his checking method ->>>
            val repository = BudgetUserRepository()
            repository.login(emailField, passwordField)

            // If we got returned user from repository and Remote server we do welcome message
            if (repository.loginUser == null) {
                Toast.makeText(this, "You are not exist in system, try to sign up.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Welcome home, ${repository.loginUser!!.nickname}.", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}