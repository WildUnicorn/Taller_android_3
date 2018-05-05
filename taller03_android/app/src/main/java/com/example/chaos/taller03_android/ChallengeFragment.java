package com.example.chaos.taller03_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChallengeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_challenge, container, false);
    }

    public boolean onKey(View view, int keyCode, KeyEvent event) {

        TextView responseText = (TextView) view.findViewById(R.id.txtIngreseASD);
        EditText myEditText = (EditText) view;

        if (responseText.getText() == "asd"){
            Toast toast1 =
                    Toast.makeText(this.getContext(),
                            "Toast por defecto", Toast.LENGTH_SHORT);

            toast1.show();
        }
        return true;
    }
}
