package com.example.dolce_v3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dolce_v3.R;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText Fullname, Email, Phone, Password, ConfirmPass;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        Fullname = findViewById(R.id.ET_Fullname);
        Email = findViewById(R.id.ET_email);
        Phone = findViewById(R.id.ET_phone);
        Password = findViewById(R.id.ET_password);
        ConfirmPass = findViewById(R.id.ET_Cpassword);

    }

    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void CheckAndRegister(View view) {
        final String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        final String fullname = Fullname.getText().toString().trim();
        final String phone = Phone.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Email.setError("Email is required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            Password.setError("Password is required");
            return;
        }
        if(password.length() < 6){
            Password.setError(">= 6 characters");
            return;
        }

        progressBar.setVisibility(view.VISIBLE);
    }
}