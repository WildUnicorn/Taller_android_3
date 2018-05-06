package com.example.chaos.taller03_android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chaos.taller03_android.model.Data;


public class CambiarTiempoFragment extends Fragment {
    private Data d;
    private EditText txtCambiarTiempo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cambiar_tiempo, container, false);

        d = new Data();
        txtCambiarTiempo = (EditText) view.findViewById(R.id.txtCambiarTiempo);
        Button btnCambiarTiempo = (Button) view.findViewById(R.id.btnCambiarTiempo);
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

        AlertDialog.Builder confirmar = new AlertDialog.Builder(v.getContext());
        confirmar.setTitle("Confirmar");
        confirmar.setMessage("¿Desea cambiar el tiempo?");
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

    public void aceptar(int tiempo) {
        d.setTiempo(tiempo);
        Toast.makeText(getView().getContext(), "Nuevo tiempo asginado: " + tiempo + " segundos.", Toast.LENGTH_LONG).show();
    }

    ;
}
