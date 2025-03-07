package com.example.android_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private EditText edit1,edit2;
    private Button btn1;
    private Button btn2;
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
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("Preference", Context.MODE_PRIVATE);
        nombre = getSharedNombre();
        run = getSharedRun();
        correo = getSharedCorreo();
        especialidad = getSharedEspecialidad();
        ubicacionConsulta = getSharedUbicacionConsulta();
        contrasena = getSharedContrasena();
        registrado = getSharedRegistrado();

        text1=findViewById(R.id.text1);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidForm()){
                    registrado=1;
                    saveShared(nombre,run,correo,especialidad,ubicacionConsulta,contrasena,registrado);
                    Intent intent = new Intent(MainActivity.this,Splashscreen.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Run y/o contrasena invalida",Toast.LENGTH_LONG).show();

                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });

    }



    private boolean isValidForm(){
        boolean r=false;
        if(TextUtils.isEmpty(edit1.getText())){
            edit1.setError("El run es obligatorio");
        }else if(TextUtils.isEmpty(edit2.getText())){
            edit2.setError("La contraseña es obligatoria");

        }else{
            if(edit1.getText().toString().equals(run) && edit2.getText().toString().equals(contrasena)){
                r = true;

            }else {
                edit1.setError("Run y/o contrasena invalida");
            }
        }

        return r;
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