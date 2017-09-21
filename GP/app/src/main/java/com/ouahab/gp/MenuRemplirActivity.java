package com.ouahab.gp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuRemplirActivity extends AppCompatActivity {

    Button situer;
    Button placer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_remplir);
        placer = (Button) findViewById(R.id.Placer);
        situer = (Button) findViewById(R.id.situer);
        placer.setOnClickListener(btn_placer);
        situer.setOnClickListener(btn_situer);
    }

    View.OnClickListener btn_placer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), RemplirActivity.class);
            startActivity(intent);
        }
    };

        View.OnClickListener btn_situer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),SeSituerActivity.class);
                    startActivity(intent);
                }
        };
}