package com.example.android_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView text1_second, text2_second;
    private Button btn_atras_second;
    private SharedPreferences prefs;
    private String nombre;
    private String run;
    private String correo;
    private String especialidad;
    private String ubicacionConsulta;
    private String contrasena;
    private Integer registrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        prefs = getSharedPreferences("Preference", Context.MODE_PRIVATE);
        nombre = getSharedNombre();
        run = getSharedRun();
        correo = getSharedCorreo();
        especialidad = getSharedEspecialidad();
        ubicacionConsulta = getSharedUbicacionConsulta();
        contrasena = getSharedContrasena();
        registrado = getSharedRegistrado();

        text1_second =findViewById(R.id.text1_second);
        text2_second = findViewById(R.id.text2_second);

        text2_second.setText("Dr. "+nombre);
        btn_atras_second=findViewById(R.id.btn_atras_second);


        btn_atras_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrado=0;
                saveShared(nombre,run,correo,especialidad,ubicacionConsulta,contrasena,registrado);
                Intent intent =new Intent(SecondActivity.this,Splashscreen.class);
                startActivity(intent);

            }
        });
    }




    void saveShared(String nombre, String run, String correo, String especialidad, String ubicacionConsulta, String contrasena, int registrado){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre", nombre);
        editor.putString("run",run);
        editor.putString("correo",correo);
        editor.putString("especialidad",especialidad);
        editor.putString("ubicacionConsulta",ubicacionConsulta);
        editor.putString("contrasena",contrasena);
        editor.putInt("registrado",registrado);
        editor.apply();
    }

    String getSharedNombre(){
        return prefs.getString("nombre","");
    }
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