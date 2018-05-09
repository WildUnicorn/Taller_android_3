package com.example.chaos.taller03_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void IrAlJuego(View view) {
        Intent navegation = new Intent(getApplicationContext(), NavegadorActivity.class);
        startActivity(navegation);
    }
}
