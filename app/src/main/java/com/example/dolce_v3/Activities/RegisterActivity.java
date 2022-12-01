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
import android.widget.Toast;

import com.example.dolce_v3.Helper.DB_Helper;
import com.example.dolce_v3.MainActivity;
import com.example.dolce_v3.R;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText Fullname, Email, Phone, Password, ConfirmPass;
    ProgressBar progressBar;

    DB_Helper db;

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

        db = new DB_Helper(this);
    }

    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void CheckAndRegister(View view) {
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String Cpassword = ConfirmPass.getText().toString();
        String fullname = Fullname.getText().toString();
        String phone = Phone.getText().toString();

        if(email.equals("") || password.equals("") || Cpassword.equals("") || fullname.equals("") || phone.equals("")){
            Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            if(password.equals(Cpassword)){
                Boolean checkUser = db.checkEmail(email);
                if(checkUser == false){
                    Boolean insert = db.insertData(email, password);
                    if(insert == true){
                        Toast.makeText(RegisterActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, LoginActivity.class));
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Email Already Exists", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, LoginActivity.class));
                }
            }
            else{
                Toast.makeText(RegisterActivity.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}