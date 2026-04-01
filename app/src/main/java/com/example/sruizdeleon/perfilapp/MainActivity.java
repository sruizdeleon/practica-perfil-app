package com.example.sruizdeleon.perfilapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sruizdeleon.perfilapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Declaramos la variable de binding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializamos el binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Programamos el clic del botón
        binding.btnCrearPerfil.setOnClickListener(v -> {
            validarYEnviar();
        });
    }

    // Función para validar el envío
    private void validarYEnviar() {
        // Extraemos los textos
        String nombre = binding.etNombre.getText().toString();
        String email = binding.etEmail.getText().toString();
        String edadStr = binding.etEdad.getText().toString();

        // Validamos el campo nombre
        if (nombre.isEmpty()) {
            Toast.makeText(this, "Por favor, rellena tu nombre.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validamos el campo email
        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor, rellena tu email.", Toast.LENGTH_SHORT).show();
            return;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor, escribe un mail válido.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validamos el campo edad
        if (edadStr.isEmpty()) {
            Toast.makeText(this, "Por favor, rellena tu edad.", Toast.LENGTH_SHORT).show();
            return;
        }
        int edad = Integer.parseInt(edadStr);
        if(edad < 0) {
            Toast.makeText(this, "Por favor, introduce una edad mayor de 0 años.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edad > 100) {
            Toast.makeText(this, "Por favor, introduce una edad menor de 100 años.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtenemos el RadioButton seleccionado
        int idSeleccionado = binding.rgHobbies.getCheckedRadioButtonId();
        // Validamos el RadioButton
        if (idSeleccionado == -1) {
            Toast.makeText(this, "Por favor, selecciona un hobby", Toast.LENGTH_SHORT).show();
            return;
        }

        // Buscamos el RadioButton para sacar su nombre
        RadioButton rbSeleccionado = findViewById(idSeleccionado);
        String hobby = rbSeleccionado.getText().toString();

        // Creamos el Intent para guardar datos y pasárselos a PerfilActivity
        Intent intent = new Intent(this, PerfilActivity.class);

        // Guardamos los datos con su clave
        intent.putExtra("EXTRA_NOMBRE", nombre);
        intent.putExtra("EXTRA_EDAD", edadStr);
        intent.putExtra("EXTRA_EMAIL", email);
        intent.putExtra("EXTRA_HOBBY", hobby);

        // Iniciamos la actividad de Perfil
        startActivity(intent);
    }

}