package com.example.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
   TextView t;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);

            t= findViewById(R.id.emaill);
            String email= getIntent().getStringExtra(getString(R.string.email));

            if(email!=null){
            t.setText(" "+email);
            }else{
                if(MainActivity.verify(getIntent().getData().getSchemeSpecificPart()))
                t.setText(" "+getIntent().getData().getSchemeSpecificPart());
            }

        t.setOnClickListener(this);
    }

    public void onClick(View v){

        if(v.getId()==R.id.emaill){
            Intent a = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",getIntent().getStringExtra(getString(R.string.email)),null));

            try {
                startActivity(a);
            }catch (ActivityNotFoundException e){
                Log.i("exception",e.getMessage());
            }
        }
    }
}
