package com.example.stage_ete_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    //déclaration des variables
    private EditText fullName, email, cin, phonenumber, password, confirmpassword;
    private Button btnSignUp;
    private TextView goToSignIn;
    private String fullNameInput, emailInput, cinInput, phoneInput, passwordInput, confirmPasswordInput;
    private final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //affectation des views
        goToSignIn = findViewById(R.id.gotoSignIn);
        fullName = findViewById(R.id.fullNameSignUp);
        cin = findViewById(R.id.cinSignUp);
        email = findViewById(R.id.emailSignUp);
        phonenumber = findViewById(R.id.phoneNumberSignUp);
        password = findViewById(R.id.passwordSignUp);
        confirmpassword = findViewById(R.id.confirmPasswordSignUp);
        btnSignUp = findViewById(R.id.btnSignUp);

        //Actions


        goToSignIn.setOnClickListener(v -> {

            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));

        });
        btnSignUp.setOnClickListener(v ->{
            if (validate()){
                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
            }

        });
    }
    private boolean validate(){
        boolean result =false;
        fullNameInput = fullName.getText().toString().trim();
        emailInput = email.getText().toString().trim();
        cinInput = cin.getText().toString().trim();
        phoneInput = phonenumber.getText().toString().trim();
        passwordInput = password.getText().toString().trim();
        confirmPasswordInput = confirmpassword.getText().toString().trim();
        if (fullNameInput.length()<7){
            fullName.setError("fullname invalide !!!");
        } else if (!isValidPattern(emailInput, EMAIL_PATTERN)){
            email.setError("email is invalide");
        }else
            result = true;
        return result;

    }
    private boolean isValidPattern(String mot, String patternn) {
        Pattern pattern = Pattern.compile(patternn);
        Matcher matcher = pattern.matcher(mot);
        return matcher.matches();
    }
}