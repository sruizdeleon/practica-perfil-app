package com.example.sruizdeleon.perfilapp;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Importante: Asegúrate de que esta clase de binding coincida con tu nombre de archivo XML
import com.example.sruizdeleon.perfilapp.databinding.ActivityAjustesBinding;

public class AjustesActivity extends AppCompatActivity {

    private ActivityAjustesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflamos el binding de Ajustes
        binding = ActivityAjustesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Creamos el listener para navegar a Perfil finalizando la actividad
        binding.btnVolverPerfil.setOnClickListener(v -> {
            finish();
        });

        // Switch de Notificaciones
        binding.swNotificaciones.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Comprobamos si está activo y mostramos su toast correspondiente
            if (isChecked) {
                Toast.makeText(this, "Notificaciones Activadas", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Notificaciones Desactivadas", Toast.LENGTH_SHORT).show();
            }
        });


        // Switch del Modo Oscuro
        binding.swModoOscuro.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Comprobamos si está activo y mostramos su toast correspondiente
            if (isChecked) {
                Toast.makeText(this, "Modo OSCURO activado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Modo CLARO activado", Toast.LENGTH_SHORT).show();
            }
        });

        // CheckBox de Recordar sesión
        binding.cbRecordarSesion.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Comprobamos si está checado y mostramos su toast correspondiente
            if (isChecked) {
                Toast.makeText(this, "Sesión recordada", Toast.LENGTH_SHORT).show();
            }
        });

        // Inicializamos el valor por defecto
        int valorInicial = 16;
        String textoFormateado = getString(R.string.tamano_texto, valorInicial);
        binding.tvTamanoTexto.setText(textoFormateado);

        // Seekbar para cambio de tamaño de texto
        binding.sbTamano.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Como pediste un mínimo de 12, nos aseguramos aquí
                int valorReal = Math.max(progress, 12);
                String textoFormateado = getString(R.string.tamano_texto, valorReal);
                binding.tvTamanoTexto.setText(textoFormateado);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}