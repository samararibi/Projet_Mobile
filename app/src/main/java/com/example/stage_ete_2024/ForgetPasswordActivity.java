package com.example.stage_ete_2024;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ForgetPasswordActivity extends AppCompatActivity {
    private Button goToSignInPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);

        goToSignInPass = findViewById(R.id.gotosifninfromforgetpaaswd);
        goToSignInPass.setOnClickListener(v -> {

            startActivity(new Intent(ForgetPasswordActivity.this, SignInActivity.class));
        });

    }
}