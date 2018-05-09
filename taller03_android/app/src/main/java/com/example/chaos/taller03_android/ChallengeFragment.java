package com.example.chaos.taller03_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

import com.example.chaos.taller03_android.model.Data;
import com.example.chaos.taller03_android.model.Palabra;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChallengeFragment extends Fragment {
    private EditText txtInserteASD;
    private TextView txtBien;
    private TextView txtMal;
    private TextWatcher text = null;
    private Data d;
    private Palabra p;

    private ListView lista;
    private int contadorBien;
    private int contadorMal;
    private String palabra;
    private CountDownTimer tiempo;
    private List<String> listado;
    private int contadorIntentos;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);
        txtInserteASD = (EditText) view.findViewById(R.id.txtIngreseASD);
        txtBien = (TextView) view.findViewById(R.id.txtAciertos);
        txtMal = (TextView) view.findViewById(R.id.txtFallos);
        Button btnReset = (Button) view.findViewById(R.id.btnReset);
        lista= (ListView)view.findViewById(R.id.listHistorial);
        d = new Data();
        listado= new ArrayList<>();

        btnReset.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        } );
        cargarPalabra();
        contadorIntentos=0;
        contadorBien = 0;
        contadorBien = 0;

        tiempo = new CountDownTimer(d.getTiempo(), 1000) {
            @Override
            public void onTick(long l) {
                Log.v("Tiempo: ", l / 1000 + "s");

            }

            @Override
            public void onFinish() {
                txtInserteASD.setEnabled(false);
                Toast.makeText(getView().getContext(), "Tiempo!", Toast.LENGTH_LONG).show();
                tiempo.cancel();

            }
        };

        tiempo.start();

        txtInserteASD.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                text = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        if (txtInserteASD.length() >= palabra.length()) {
                            if (txtInserteASD.getText().toString().equalsIgnoreCase(palabra)) {
                                Toast.makeText(getView().getContext(), "Bien: " + palabra.toLowerCase(), Toast.LENGTH_LONG).show();
                                contadorBien++;
                                ingresarPalabra(txtInserteASD.getText().toString());
                                contadorIntentos++;
                                txtBien.setText(String.valueOf(contadorBien));

                            } else {
                                contadorMal++;
                                contadorIntentos++;
                                ingresarPalabra("Mal: "+txtInserteASD.getText().toString());
                                txtMal.setText(String.valueOf(contadorMal));
                                Toast.makeText(getView().getContext(), "Mal: " + palabra.toLowerCase(), Toast.LENGTH_LONG).show();
                            }
                            ArrayAdapter<String> adaptador;

                            adaptador = new ArrayAdapter<String>(
                                    getActivity(),android.R.layout.simple_list_item_1,getFrases());

                            lista.setAdapter( adaptador );

                            txtInserteASD.setText("");

                        }

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                };
                txtInserteASD.addTextChangedListener(text);
            }
        });
        return view;

    }

    public void cargarPalabra() {
        // Instanciar nuevo objeto Palabra.
        p = d.getPalabra();

        // Cargar palabra string con el Objeto palabra.
        palabra = p.getPalabra();

    }

    public void ingresarPalabra(String palabra) {
        listado.add(contadorIntentos+") "+palabra);
    }

    public List<String> getFrases(){
        return listado;
    }


}
