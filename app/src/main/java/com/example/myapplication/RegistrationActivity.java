package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    Button registration;
    EditText emailEd,passwordEd,passwordEd1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registration= findViewById(R.id.registration);
        emailEd= findViewById(R.id.emailEd);
        passwordEd= findViewById(R.id.passwordEd);
        passwordEd1=findViewById(R.id.passwordEd1);

        registration.setOnClickListener(this);
    }

    private boolean verify(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void showToast(String contenuto){
        Toast.makeText(this, contenuto,Toast.LENGTH_LONG).show();
    }

    private void doLogin(String email,String password,String password1){
        if(!verify(email)){
            showToast(getString(R.string.emaile));
        }else if(password.length()<MainActivity.PASSWORD_LEN){
            showToast(getString(R.string.passworde));
        }else if(password.equals(password1)){
            showToast(getString(R.string.complimenti));
            Intent main= new Intent(this,MainActivity.class);
            startActivity(main);
        }else{
            showToast(getString(R.string.passworde1));
        }
    }

    @Override
    public void onClick(View v){

        emailEd= findViewById(R.id.emailEd);
        passwordEd= findViewById(R.id.passwordEd);
        passwordEd1= findViewById(R.id.passwordEd1);

        if(v.getId()==R.id.registration){
            doLogin(emailEd.getText().toString(),passwordEd.getText().toString(),passwordEd1.getText().toString());
        }
    }
}
