package com.example.macmini_buzinger03.angeldam;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by macmini-buzinger03 on 20/4/16.
 */
public class LoginActivity extends Activity {
    String correo = "";
    String pass="";
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnRegistro=(Button)findViewById(R.id.btnRegistro);
        Button btnLogeo=(Button)findViewById(R.id.btnLogeo);

        TextView txtRecuperarCont=(TextView)findViewById(R.id.txtRecuperarCont);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        txtRecuperarCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RecuperarContActivity.class);
                startActivity(intent);
            }
        });


    }


}
