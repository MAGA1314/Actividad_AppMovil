package com.maga.actividad_appmovil;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity2 extends AppCompatActivity {

    Button nuevoaleatorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        nuevoaleatorio = findViewById(R.id.btnrepetir);

        // Recibir el array de nombres de la primera actividad
        Intent intent = getIntent();
        String[] nombres = intent.getStringArrayExtra("nombres");
        if (nombres!= null && nombres.length > 0) {
            // Seleccionar un nombre aleatorio
            Random random = new Random();
            int indiceAleatorio = random.nextInt(nombres.length);
            String nombreAleatorio = nombres[indiceAleatorio];
            // Mostrar el nombre aleatorio en el EditText
            EditText editTextResultado = findViewById(R.id.etnombrealeatorio);
            editTextResultado.setText(nombreAleatorio);
        }

        nuevoaleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent new );
            }
        });
    }

}