package com.example.chaos.taller03_android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.chaos.taller03_android.model.Palabra;

public class CambiarPalabraFragment extends Fragment {
    private Data d;
    private TextView lblPalabraActual;
    private EditText txtCambiarPalabra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cambiar_palabra, container, false);

        d = new Data();
        txtCambiarPalabra = (EditText) view.findViewById(R.id.txtCambiarPalabra);
        lblPalabraActual = (TextView) view.findViewById(R.id.lblPalabraActual);
        Button btnCambiarPalabra = (Button) view.findViewById(R.id.btnCambiarPalabra);
        lblPalabraActual.setText("Palabra actual: " + d.frase + ".");

        btnCambiarPalabra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarPalabra(view);
            }
        });

        return view;
    }

    public void cambiarPalabra(View v) {
        final String palabra = txtCambiarPalabra.getText().toString();

        if (palabra.length() > 10) {
            Toast.makeText(getView().getContext(),
                    "Máximo 10 caracteres.",
                    Toast.LENGTH_LONG).show();

        } else if (palabra.length() < 3) {
            Toast.makeText(getView().getContext(),
                    "Mínimo 3 caracteres.",
                    Toast.LENGTH_LONG).show();
        } else {

            AlertDialog.Builder confirmar = new AlertDialog.Builder(v.getContext());
            confirmar.setTitle("Confirmar");
            confirmar.setMessage("¿Desea cambiar la palabra a " + palabra + "?");
            confirmar.setCancelable(false);
            confirmar.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Palabra p = new Palabra();
                    p.setPalabra(palabra);
                    aceptar(p);
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

    public void aceptar(Palabra p) {
        d.setPalabra(p);
        d.frase=p.getPalabra();
        lblPalabraActual.setText("Palabra actual: " + d.frase + ".");
        Toast.makeText(getView().getContext(), "Nueva palabra asginada: " + d.frase, Toast.LENGTH_LONG).show();
        txtCambiarPalabra.setText("");
    }

}
