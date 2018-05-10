package com.example.chaos.taller03_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.chaos.taller03_android.model.Data;


public class TablaTiemposFragment extends Fragment {
    private ListView listado;
    private Data d;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabla_tiempos, container, false);
        d= new Data();

        if (d.listaTiempo==null){
            d.listaTiempo.add( "Listado" );
        }

        listado = (ListView) view.findViewById(R.id.listTiempos);
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(
                getActivity(),android.R.layout.simple_list_item_1,d.listaTiempo);
        listado.setAdapter( adaptador );

        return view;
    }
}