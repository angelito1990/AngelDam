package com.example.macmini_buzinger03.angeldam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by macmini-buzinger03 on 20/4/16.
 */
public class TutorialActivity extends Activity {



    Button btnRegistro;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        btnRegistro=(Button)findViewById(R.id.btnRegistro);
        btnLogin=(Button)findViewById(R.id.btnLogin);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TutorialActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}
