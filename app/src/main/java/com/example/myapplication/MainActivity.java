package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button login,registration;
    EditText emailEd,passwordEd;
    public static final int PASSWORD_LEN=6;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login= findViewById(R.id.login);
        registration= findViewById(R.id.registration);
        emailEd= findViewById(R.id.emailEd);
        passwordEd= findViewById(R.id.passwordEd);

        if(hasInvitation()){
            registration.setVisibility(View.VISIBLE);
        }

        login.setOnClickListener(this);
        registration.setOnClickListener(this);
    }

    private boolean hasInvitation(){
        return true;
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Lifecycle","onStart");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Lifecycle","onResume");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Lifecycle","onPause");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Lifecycle","onStop");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Lifecycle","onDestroy");

    }

    public static boolean verify(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void showToast(String contenuto){
        Toast.makeText(this, contenuto,Toast.LENGTH_LONG).show();
    }

    private void doLogin(String email,String password){
        if(!verify(email)){
            showToast(getString(R.string.emaile));
        }else if(password.length()<PASSWORD_LEN){
            showToast(getString(R.string.passworde));
        }else{
            Intent welcome= new Intent(this,WelcomeActivity.class);
            welcome.putExtra(getString(R.string.email),email);
            startActivity(welcome);
        }
    }

    @Override
    public void onClick(View view){

        emailEd= findViewById(R.id.emailEd);
        passwordEd= findViewById(R.id.passwordEd);

        if(view.getId()==R.id.login){
            doLogin(emailEd.getText().toString(),passwordEd.getText().toString());
        }else if(view.getId()==R.id.registration){
            Intent register = new Intent(this,RegistrationActivity.class);
            startActivity(register);
        }

    }

}

