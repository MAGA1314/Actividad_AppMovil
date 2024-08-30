package com.maga.actividad_appmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String tag = "";
    Button Aleatorio, Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el ListView y el adaptador
        listView = findViewById(R.id.listView);
        Aleatorio =findViewById(R.id.btnAleatorio);
        Salir = findViewById(R.id.btnSalir);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        // Recuperar el mensaje extra del Intent
        Intent intent = getIntent();
        if (intent!= null) {
            String mensaje = intent.getStringExtra("mensaje");
            TextView textView = findViewById(R.id.TVtexto);
            textView.setText(mensaje);
        }

        Button btnAgregar = findViewById(R.id.btnAgregar);
        Button btnSalir = findViewById(R.id.btnSalir); // Se ha agregado esta línea

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = findViewById(R.id.etnombre);
                String texto = editText.getText().toString();
                if (!texto.isEmpty()) {
                    adapter.add(texto);
                    editText.setText(""); // Limpiar el EditText después de agregar
                } else {
                    Toast.makeText(MainActivity.this, "Por favor ingrese algo.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatosALineaDos();
            }
        });
        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    // Método para enviar los datos a la segunda actividad
    public void enviarDatosALineaDos() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (int i = 0; i < adapter.getCount(); i++) {
            listaNombres.add((String) adapter.getItem(i));
        }
        Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
        intent.putExtra("nombres", listaNombres.toArray(new String[0]));
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag, "Estoy en OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "Bienvenido de nuevo");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag, "Estoy en OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "Estoy en OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "Estoy en OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "Estoy en OnDestroy");
    }
}
