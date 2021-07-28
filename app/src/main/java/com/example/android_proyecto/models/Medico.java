package com.example.android_proyecto.models;

import io.realm.RealmObject;

public class Medico extends RealmObject {
    private String nombre;
    private String run;
    private String correo;
    private String especialidad;
    private String ubicacionConsulta;
    private String contrasena;

    public Medico() {
    }

    public Medico(String nombre, String run, String correo, String especialidad, String ubicacionConsulta, String contrasena) {
        this.nombre = nombre;
        this.run = run;
        this.correo = correo;
        this.especialidad = especialidad;
        this.ubicacionConsulta = ubicacionConsulta;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUbicacionConsulta() {
        return ubicacionConsulta;
    }

    public void setUbicacionConsulta(String ubicacionConsulta) {
        this.ubicacionConsulta = ubicacionConsulta;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
