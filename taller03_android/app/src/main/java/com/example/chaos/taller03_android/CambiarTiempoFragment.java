package com.example.chaos.taller03_android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaos.taller03_android.model.Data;


public class CambiarTiempoFragment extends Fragment {
    private Data d;
    private TextView lblTiempoActual;
    private EditText txtCambiarTiempo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cambiar_tiempo, container, false);

        d = new Data();
        txtCambiarTiempo = (EditText) view.findViewById(R.id.txtCambiarPalabra);
        lblTiempoActual = (TextView) view.findViewById(R.id.lblTiempoActual);
        Button btnCambiarTiempo = (Button) view.findViewById(R.id.btnCambiarTiempo);

        lblTiempoActual.setText("Tiempo actual: " + d.getTiempo() / 1000 + " segundos.");

        btnCambiarTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarTiempo(view);
            }
        });

        return view;
    }

    public void cambiarTiempo(View v) {
        final int tiempo = Integer.parseInt(txtCambiarTiempo.getText().toString());
        if (validarTiempo(tiempo) == true) {

            AlertDialog.Builder confirmar = new AlertDialog.Builder(v.getContext());
            confirmar.setTitle("Confirmar");
            confirmar.setMessage("¿Desea cambiar el tiempo a " + tiempo+ " segundos?");
            confirmar.setCancelable(false);
            confirmar.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    aceptar(tiempo);
                }
            });

            confirmar.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface confirmar, int i) {
                    confirmar.dismiss();
                }
            });
            confirmar.show();
        }
    }

    public boolean validarTiempo(int tiempo) {
        final boolean esValido;

        if (tiempo > 100) {
            Toast.makeText(getView().getContext(), "El tiempo máximo no puede ser superior a 100 segundos.", Toast.LENGTH_LONG).show();
            esValido = false;

        } else if (tiempo < 2) {
            Toast.makeText(getView().getContext(), "El tiempo mínimo no puede ser inferior a 2 segundos.", Toast.LENGTH_LONG).show();
            esValido = false;
        } else {
            esValido = true;
        }

        return esValido;
    }

    public void aceptar(int tiempo) {
        int time = tiempo * 1000;
        d.tiempo = time;

        lblTiempoActual.setText("Tiempo actual: " + time / 1000 + " segundos.");
        Toast.makeText(getView().getContext(), "Nuevo tiempo asginado: " + time / 1000+ " segundos.", Toast.LENGTH_LONG).show();
        txtCambiarTiempo.setText("");
    }
}
