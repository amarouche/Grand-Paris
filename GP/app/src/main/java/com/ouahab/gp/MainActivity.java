package com.ouahab.gp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btn;
    ImageButton maps;
    ImageButton remplir;
    ImageButton situer;
    ImageButton discri;
    Button maths;
    Button Remplir;
    Button situe;
    Button map;
    Button discription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maths = (Button) findViewById(R.id.Maths);
        btn = (ImageButton) findViewById(R.id.maths);
        situe = (Button) findViewById(R.id.situe);
        situer = (ImageButton) findViewById(R.id.situer);
        Remplir = (Button) findViewById(R.id.Remplir);
        remplir = (ImageButton) findViewById(R.id.remplir);
        map= (Button) findViewById(R.id.map);
        maps = (ImageButton) findViewById(R.id.maps);
        discription= (Button) findViewById(R.id.discription);
        discri = (ImageButton) findViewById(R.id.discri);

        btn.setOnClickListener(btnClick);
        maths.setOnClickListener(btnClick);
        remplir.setOnClickListener(btnClick1);
        Remplir.setOnClickListener(btnClick1);
        situe.setOnClickListener(btnClick2);
        situer.setOnClickListener(btnClick2);
        map.setOnClickListener(btnClick3);
        maps.setOnClickListener(btnClick3);
        discription.setOnClickListener(btnClick4);
        discri.setOnClickListener(btnClick4);
    }

    View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MathsActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener btnClick1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuRemplirActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener btnClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), PointsCardinauxActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener btnClick3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MapGameActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener btnClick4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), DiscriptionActivity.class);
            startActivity(intent);
        }
    };
}
