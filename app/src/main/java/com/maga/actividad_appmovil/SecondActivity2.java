package com.maga.actividad_appmovil;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        // Recibir datos de la primera actividad
        Intent intent = getIntent();
        String nombre1 = intent.getStringExtra("NOMBRE1");
        String nombre2 = intent.getStringExtra("NOMBRE2");
        String nombre3 = intent.getStringExtra("NOMBRE3");

        // Mostrar los nombres en TextViews u otros elementos según sea necesario
        TextView textViewNombre1 = findViewById(R.id.etnombre1);
        TextView textViewNombre2 = findViewById(R.id.etnombre2);
        TextView textViewNombre3 = findViewById(R.id.etnombre3);

        textViewNombre1.setText("Nombre 1: " + nombre1);
        textViewNombre2.setText("Nombre 2: " + nombre2);
        textViewNombre3.setText("Nombre 3: " + nombre3);

        // Crear una lista para almacenar los nombres
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add(nombre1);
        listaNombres.add(nombre2);
        listaNombres.add(nombre3);

        // Seleccionar aleatoriamente un nombre de la lista
        Random random = new Random();
        String nombreAleatorio = listaNombres.get(random.nextInt(listaNombres.size()));

        EditText editTextResultado = findViewById(R.id.etnombrealeatorio);
        editTextResultado.setText(nombreAleatorio);

        // Texto de los botones
        /* El boton Volver envia un mensaje a la pantalla principal que imprime: "¡Volvió a la primera pantalla!"*/
        /* El boton Repetir aleatorio Repetira la accion de escoger un nombre aleatorio y aparte mostrara un mensaje que dira: "Nuevo Aleatorio"*/

        // Configurar la accion del boton "repetir aleatorio"
        // Configurar la accion del boton "repetir aleatorio"
        Button btnRepetirAleatorio = findViewById(R.id.btnrepetir);
        btnRepetirAleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Seleccionar aleatoriamente un nombre de la lista
                String nombreAleatorio = listaNombres.get(random.nextInt(listaNombres.size()));

                // Mostrar el nombre aleatorio en el EditText
                editTextResultado.setText(nombreAleatorio);

                // Mostrar el mensaje "Nuevo Aleatorio" en un TextView
                TextView textViewMensaje = findViewById(R.id.TValeatorionuevo);
                textViewMensaje.setText("¡Nuevo Aleatorio!");
            }
        });
        // Configurar la acción del botón "Volver"
        Button btnVolver = findViewById(R.id.btnvol);
        btnVolver.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Limpiar los EditText en la segunda actividad
                editTextResultado.setText("");

                // Volver a la primera actividad
                Intent intent = new Intent(SecondActivity2.this, MainActivity.class);
                // Pasar un mensaje extra al primer Activity
                intent.putExtra("mensaje", "¡Volvió a la primera pantalla!");
                startActivity(intent);
            }
        });
    }
}