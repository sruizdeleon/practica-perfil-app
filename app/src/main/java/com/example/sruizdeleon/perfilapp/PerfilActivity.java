package com.example.sruizdeleon.perfilapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


import com.example.sruizdeleon.perfilapp.databinding.ActivityPerfilBinding;

public class PerfilActivity extends AppCompatActivity {

    // Creamos la variable del Binding
    private ActivityPerfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Inflamos el binding de Perfil
        binding = ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Recuperamos el Intent de Main
        Intent intentPerfil = getIntent();

        // Extraemos los datos usando las claves
        String nombre = intentPerfil.getStringExtra("EXTRA_NOMBRE");
        String edad = intentPerfil.getStringExtra("EXTRA_EDAD");
        String email = intentPerfil.getStringExtra("EXTRA_EMAIL");
        String hobby = intentPerfil.getStringExtra("EXTRA_HOBBY");

        // Mostramos los datos por medio de los TextViews
        binding.tvResultadoNombre.setText(nombre);
        binding.tvResultadoEdad.setText("Edad: " + edad + " años");
        binding.tvResultadoEmail.setText("Email: " + email);
        binding.tvResultadoEntrenamiento.setText("Hobby elegido: " + hobby);

        // Creamos el listener para navegar a Ajustes
        binding.btnAjustes.setOnClickListener(v -> {
            Intent intentAjustes = new Intent(this, AjustesActivity.class);
            startActivity(intentAjustes);
        });

        // Creamos el listener para navegar a Main finalizando la actividad
        binding.btnVolver.setOnClickListener(v -> {
            finish(); // Esto destruye PerfilActivity y te devuelve a la pantalla de Registro
        });

    }
}