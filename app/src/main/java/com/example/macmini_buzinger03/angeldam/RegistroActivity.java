package com.example.macmini_buzinger03.angeldam;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by macmini-buzinger03 on 20/4/16.
 */
public class RegistroActivity extends Activity {

    String nom = "";
    String ape = "";
    String correo = "";
    String pass = "";

    SQLiteDatabase bd;
    Button btnAceptarRegistro;

    EditText txtNombre;
    EditText txtApellidos;
    EditText txtEmail;
    EditText txtPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnAceptarRegistro = (Button) findViewById(R.id.btnAceptarRegistro);

        btnAceptarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registro();
                Intent intent = new Intent(RegistroActivity.this, MenuActivity.class);
                startActivity(intent);
                String n = txtNombre.getText().toString();



                // OBJETO JSON
                JSONObject json = new JSONObject();
                try {
                    json.put("Bienvenido",n);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public void registro() {

         txtNombre = (EditText) findViewById(R.id.txtNombre);
         txtApellidos = (EditText) findViewById(R.id.txtApellidos);
         txtEmail = (EditText) findViewById(R.id.txtEmail);
         txtPassword = (EditText) findViewById(R.id.txtPassword);

        // COGER LOS DATOS INTRODUCIDOS POR EL USUARIO

        nom = txtNombre.getText().toString();
        ape = txtApellidos.getText().toString();
        correo = txtEmail.getText().toString();
        pass = txtPassword.getText().toString();

        // CREAR EL OBJETO DE NUESTRA BD

        BDProyecto TBRegistro = new BDProyecto(this, "TBRegistro", null, 1);

        // PERMISO DE ESCRITURA

        bd = TBRegistro.getWritableDatabase();

        if (!duplicados(correo)) {
            String sql = "INSERT INTO TBRegistro VALUES ('" + nom + "','" + ape + "','" + correo + "','" + pass + "')";

            bd.execSQL(sql);

            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

            txtNombre.setText("");
            txtApellidos.setText("");
            txtEmail.setText("");
            txtPassword.setText("");



        }else{

            Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();

        }


    }

    // MÉTODO PARA COMPROBAR SI HAY DUPLICADOS

    public boolean duplicados(String correo) {

        boolean duplicados = false;

        String consulta = "SELECT * FROM TBRegistro WHERE email='" + correo + "'";

        Cursor fila = bd.rawQuery(consulta, null);

        if (fila.getCount() > 0) {
            duplicados = true;
        }
        return duplicados;

    }
/*
    public void enviarCorreo(){
        String texto="Gracias por registrarse en nuestra app";
        String asunto="Bienvenido";


        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{txtEmail.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT,asunto);
        intent.putExtra(Intent.EXTRA_TEXT, texto);

        try {
            startActivity(intent.createChooser(intent, "Enviando correo"));
        }catch(Exception e){
            e.printStackTrace();
        }
        startActivity(intent);


    }
*/


}

