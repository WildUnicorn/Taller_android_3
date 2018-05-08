package com.example.chaos.taller03_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

import com.example.chaos.taller03_android.model.Data;

import org.w3c.dom.Text;

public class ChallengeFragment extends Fragment {
    private EditText txtInserteASD;
    private TextView txtBien;
    private TextView txtMal;
    private TextWatcher text= null;
    private Data d;
    private int contadorBien;
    private int contadorMal;
    private  CountDownTimer tiempo;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);
        txtInserteASD= (EditText) view.findViewById(R.id.txtIngreseASD);
        txtBien= (TextView) view.findViewById(R.id.txtAciertos);
        txtMal= (TextView) view.findViewById(R.id.txtFallos);
        d= new Data();
        contadorBien=0;
        contadorBien=0;

        tiempo= new CountDownTimer(d.getTiempo(),1000) {
            @Override
            public void onTick(long l) {
                Log.v("Tiempo: ",l / 1000 + "s");

            }

            @Override
            public void onFinish() {
                txtInserteASD.setEnabled(false);
                Toast.makeText(getView().getContext(), "Tiempo!", Toast.LENGTH_LONG).show();

            }
        };

        txtInserteASD.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                text= new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {




                        if (txtInserteASD.length()>=d.getPalabra().getPalabra().length()){
                            if (txtInserteASD.getText().toString().equals( d.getPalabra().getPalabra().toLowerCase())){
                                Toast.makeText(getView().getContext(), "Bien: "+d.getPalabra().getPalabra().toLowerCase(), Toast.LENGTH_LONG).show();
                                contadorBien++;
                                txtBien.setText(String.valueOf(contadorBien));

                            }else {
                                contadorMal++;
                                txtMal.setText(String.valueOf(contadorMal));
                                Toast.makeText(getView().getContext(), "Mal: "+d.getPalabra().getPalabra().toLowerCase(), Toast.LENGTH_LONG).show();
                            }
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




}
