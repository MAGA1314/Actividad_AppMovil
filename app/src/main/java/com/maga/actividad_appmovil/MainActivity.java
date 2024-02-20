package com.maga.actividad_appmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String Tag = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = findViewById(R.id.btncontinuar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Obtener datos de EditText
                EditText editTextNombre1 = findViewById(R.id.etnombre1);
                EditText editTextNombre2 = findViewById(R.id.etnombre2);
                EditText editTextNombre3 = findViewById(R.id.etnombre3);

                String nombre1 = editTextNombre1.getText().toString();
                String nombre2 = editTextNombre2.getText().toString();
                String nombre3 = editTextNombre3.getText().toString();

                // Pasar datos a la segunda actividad
                Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                intent.putExtra("NOMBRE1", nombre1);
                intent.putExtra("NOMBRE2", nombre2);
                intent.putExtra("NOMBRE3", nombre3);

                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag,"Estoy en OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag,"Bienvenido de nuevo");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag,"Estoy en OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag,"Estoy en OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag,"Estoy en OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag,"Estoy en OnDestroy");
    }
}