package com.test.todoapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.todoapplication.R;

public class loginActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getting data input by user
        txtUsername=findViewById(R.id.splash_txt_username);
        txtPassword=findViewById(R.id.splash_txt_password);

        //getting two event given by user
        btnLogin = findViewById(R.id.splash_btn_login);
        btnCancel = findViewById(R.id.splash_btn_cancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //creating event

                String userName=txtUsername.getText().toString();
                String password=txtPassword.getText().toString();

                //validating fields

                if (userName.equals(""))
                {
                    txtUsername.setError(getString(R.string.login_username_required));
                    txtUsername.requestFocus();

                }
                else if (password.equals(""))
                {
                    txtPassword.setError(getString(R.string.login_password_required));
                    txtUsername.requestFocus();
                }
                else
                {
                    if (userName.equals("sudesh") && password.equals("sudesh"))
                    {
                        //login to app
                        //store login info in sharedpreference which can be easily add, modify/edit local storage
                        SharedPreferences preferences=getApplicationContext().getSharedPreferences("todo_app",0);
                        //opening editor of shared preferences before storing info
                        SharedPreferences.Editor editor=preferences.edit();

                        //putting key value
                        editor.putBoolean("authentication", true);
                        editor.commit();
                        Intent i= new Intent(loginActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                    else
                    {
                        txtUsername.setError(getString(R.string.invalid_login));
                    }
                }

            }
        });


    }
}
