package com.ouahab.gp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

import static java.lang.System.out;

public class MathsActivity extends AppCompatActivity {
    Button easy;
    String difficulte;
    Button exercice1;
    Button exo_btn;
    Button exercice3;
    Button way;
    Button hard;
    LinearLayout farme;
    String ids;
    String nv;
    Context self = this;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        if(i == 1)
        {
            createFullView();
        }
        else
            createFullView();
    }

    public void createFullView() {
        farme = (LinearLayout) findViewById(R.id.farme);
        easy = new Button(self);
        easy.setText("NIVEAU 1");
        easy.setTag("facile");
        LinearLayout.LayoutParams le = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        le.setMargins(0, 40, 0, 0);
        easy.setLayoutParams(le);
        easy.setBackgroundDrawable(getResources().getDrawable(R.drawable.verif));
        easy.setOnClickListener(btnClick);
        farme.addView(easy);
        way = new Button(self);
        way.setText("NIVEAU 2");
        way.setTag("moyen");
        LinearLayout.LayoutParams lpe = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lpe.setMargins(0, 40, 0, 0);
        way.setLayoutParams(lpe);
        way.setOnClickListener(btnClick);
        way.setBackgroundDrawable(getResources().getDrawable(R.drawable.moyen));
        farme.addView(way);
        hard = new Button(self);
        hard.setTag("difficile");
        hard.setText("NIVEAU 3");
        hard.setBackgroundDrawable(getResources().getDrawable(R.drawable.hard));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 40, 0, 0);
        hard.setLayoutParams(lp);
        hard.setOnClickListener(btnClick);
        farme.addView(hard);
    }
    View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i = 1;
            difficulte = v.getTag().toString();
            createview1();
        }
    };


    public void createview1() {
        farme = (LinearLayout) findViewById(R.id.farme);
        fileReading();
        farme.removeView(hard);
        farme.removeView(way);
        farme.removeView(easy);
    }

    View.OnClickListener btnClick1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ExerciceMathsActivity.class);
            intent.putExtra("ids", v.getTag().toString());
            intent.putExtra("niveau", difficulte);
            startActivity(intent);
        }
    };

    public void parseJson(JSONObject response) {
        try {
            JSONObject exercices = response.getJSONObject("exercices");

            JSONArray niveau;
            if (difficulte.equals("facile"))
            {
                niveau = exercices.getJSONArray("facile");
            }
            else if(difficulte.equals("moyen"))
            {
                niveau = exercices.getJSONArray("moyen");
            }
            else
                niveau = exercices.getJSONArray("difficile");

            for (int i = 0; i < niveau.length(); i++)
            {
                JSONObject test = niveau.getJSONObject(i);
                exo_btn = new Button(self);
                //btn.setId(Integer.parseInt("niveau1"));
                // btn.setBackgroundColor(Color, #34AC00);
                ids = test.getString("id");
                exo_btn.setText("exercice "+ (Integer.parseInt(ids) +1));
                exo_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.verif));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                layoutParams.setMargins(30, 20, 30, 0);
                exo_btn.setTag(ids);
                exo_btn.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                JSONObject exo = test.getJSONObject("exercice");
                String rien = exo.getString("text");
                farme.addView(exo_btn, layoutParams);
                exo_btn.setOnClickListener(btnClick1);
                //out.println(rien);
                //out.println(ids);
            }
        } catch (Exception e) {
            Log.e("Parsing Error::", e.toString());
            e.printStackTrace();
        }
    }
    public String loadJson() {
        String json = null;
        try {
            InputStream is = getAssets().open("maths.json");
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
    public void fileReading() {
        try {
            JSONObject jsonObject = new JSONObject(loadJson());
            parseJson(jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
