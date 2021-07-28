package com.example.android_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends Activity {
    private SharedPreferences prefs;
    private Integer registrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        prefs = getSharedPreferences("Preference", Context.MODE_PRIVATE);
        registrado = getSharedRegistrado();
        //Toast.makeText(getApplicationContext(),registrado,Toast.LENGTH_LONG).show();

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if(registrado==1){
                    Intent intent = new Intent(Splashscreen.this, SecondActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        Timer tiempoactividad = new Timer();
        tiempoactividad.schedule(tarea, 1500);

    }





    String getSharedNombre(){ return prefs.getString("nombre","");}
    String getSharedRun(){
        return prefs.getString("run","");
    }
    String getSharedCorreo(){
        return prefs.getString("correo","");
    }
    String getSharedEspecialidad(){
        return prefs.getString("especialidad","");
    }
    String getSharedUbicacionConsulta(){
        return prefs.getString("ubicacionConsulta","");
    }
    String getSharedContrasena(){
        return prefs.getString("contrasena","");
    }
    Integer getSharedRegistrado(){
        return prefs.getInt("registrado",0);
    }
}