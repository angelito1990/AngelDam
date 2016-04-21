package com.example.macmini_buzinger03.angeldam;

/**
 * Created by macmini-buzinger03 on 21/4/16.
 */
public class Registro {

    String nombre,apellidos,email,password;
    public Registro(String nombre, String apellidos, String email,String password){

            this.nombre=nombre;
            this.apellidos=apellidos;
            this.email=email;
            this.password=password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
