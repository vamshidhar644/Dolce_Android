package com.example.dolce_v3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dolce_v3.Helper.DB_Helper;
import com.example.dolce_v3.MainActivity;
import com.example.dolce_v3.R;

public class LoginActivity extends AppCompatActivity {

    EditText Email, Password;

    DB_Helper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.Login_email);
        Password = (EditText) findViewById(R.id.Login_password);

        db = new DB_Helper(this);
    }

    public void mainActivity(View view) {
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if(email.equals("") || password.equals("")){
            Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean checkUserpass = db.checkPassword(email, password);
            if(checkUserpass == true){
                Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
            else{
                Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
    public void forgotPass(View view) {

    }
}