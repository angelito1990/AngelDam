package com.example.macmini_buzinger03.angeldam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BDProyecto extends SQLiteOpenHelper{
    String sentenciaSQL = "CREATE TABLE TBRegistro (nombre TEXT, apellidos TEXT, email VARCHAR, password TEXT)";
    //Constructor
    public BDProyecto(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(sentenciaSQL);
        String sql = "INSERT INTO TBRegistro VALUES ('Angel', 'gutierrez', 'guti_13772@hotmail.com', 'noviembre')";

        bd.execSQL(sql); //Ejecuta la sentencia SQL

    }
    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        //Se crea la nueva versión de la tabla
        bd.execSQL(sentenciaSQL);
    } }