package com.example.macmini_buzinger03.angeldam;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by macmini-buzinger03 on 21/4/16.
 */
public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        JSONObject json = new JSONObject();
        TextView txtTexto= (TextView)findViewById(R.id.txtTexto);



    }
}
