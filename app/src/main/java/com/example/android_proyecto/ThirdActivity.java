package com.example.android_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText edit1,edit2,edit3,edit6;
    private Button btn_registrar;
    private Spinner spinner1, spinner2;
    private static final String[] speciality = {"cirujano","anestesista","medico general"};
    private static final String[] ubication = {"consulta 1","consulta 2","consulta 3"};
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
        setContentView(R.layout.activity_third);

        prefs = getSharedPreferences("Preference", Context.MODE_PRIVATE);

        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        edit3=findViewById(R.id.edit3);
        edit6=findViewById(R.id.edit6);
        btn_registrar=findViewById(R.id.btn_registrar);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_spinner_item,speciality);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);





        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_spinner_item,ubication);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);




        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre=edit1.getText().toString();
                run=edit2.getText().toString();
                correo=edit3.getText().toString();
                contrasena=edit6.getText().toString();
                registrado=1;
                saveShared(nombre,run,correo,especialidad,ubicacionConsulta,contrasena,registrado);
                Intent intent =new Intent(ThirdActivity.this,Splashscreen.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),nombre+run+correo+especialidad+ubicacionConsulta+contrasena+registrado,Toast.LENGTH_LONG).show();



            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        Spinner spinner1 = (Spinner)parent;
        Spinner spinner2 = (Spinner)parent;

        if (spinner1.getId()==R.id.spinner1) {
            switch (position) {
                case 0:
                    // Whatever you want to happen when the first item gets selected
                    especialidad = "cirujano";
                    break;
                case 1:
                    // Whatever you want to happen when the second item gets selected
                    especialidad = "anestesista";
                    break;
                case 2:
                    // Whatever you want to happen when the thrid item gets selected
                    especialidad = "medico general";
                    break;

            }
        }

        if (spinner2.getId()==R.id.spinner2) {
            switch (position) {
                case 0:
                    // Whatever you want to happen when the first item gets selected
                    ubicacionConsulta = "consulta 1";
                    break;
                case 1:
                    // Whatever you want to happen when the second item gets selected
                    ubicacionConsulta = "consulta 2";
                    break;
                case 2:
                    // Whatever you want to happen when the thrid item gets selected
                    ubicacionConsulta = "consulta 3";
                    break;

            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
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