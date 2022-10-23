package com.student.loginapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
//    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEmail = findViewById(R.id.textInputEmail);
        textInputPassword = findViewById(R.id.textInputPassword);
    }

    //    validation methods with boolean keyword
    private Boolean validateEmail() {
//        For text types in email-input-field =
//        email-input-layout.
//        to get text we're using (getEditText().getText().toString()).
//        to remove extra spaces before and after text we'll use (.trim())
        String emailInput = Objects.requireNonNull(textInputEmail.getEditText()).getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field cannot be empty");
            return false;
        } else if (!emailInput.matches(emailPattern)) {
//            else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){ //this is build-in pattern matcher
            textInputEmail.setError("Please enter a valid email address");
            Toast.makeText(this, R.string.email_order, Toast.LENGTH_LONG).show();
            return false;
        } else {
//            remove error msg and room for it
            textInputEmail.setError(null);
            textInputEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String passInput = Objects.requireNonNull(textInputPassword.getEditText()).getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$";
        if (passInput.isEmpty()) {
            textInputPassword.setError("Field cannot be empty");
            return false;
        } else if (!passInput.matches(passwordVal)) {
            textInputPassword.setError("Password is too weak");
            Toast.makeText(this, R.string.password_order, Toast.LENGTH_LONG).show();
            return false;
        } else {
            textInputPassword.setError(null);
            textInputPassword.setErrorEnabled(false);
            return true;
        }
    }

    public void confirmLogin(View view) {
        if (!validateEmail() | !validatePassword()) {  //use && or | both means check all args || means if first agr comes true it will ignore the rest args
            return;
        } else {
            Intent iAfterLogin = new Intent(getApplicationContext(), AfterLogin.class);
            startActivity(iAfterLogin);
        }

    }
}