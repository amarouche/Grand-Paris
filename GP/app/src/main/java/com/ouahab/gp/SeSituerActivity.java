package com.ouahab.gp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.Random;

import uk.co.senab.photoview.PhotoViewAttacher;

import static android.view.Gravity.CENTER;
import static java.lang.System.out;

public class SeSituerActivity extends AppCompatActivity {
    ImageView imageView;
    Context self = this;
    Button verif;
    TextView quest;
    LinearLayout layout;
    String rpn;
    TextView phrase;
    TextView phrase1;
    String qst;
    ImageButton flech;
    ImageButton flech1;
    EditText reponse;
    String value_reponse;
    int i = 0;
    int j = 0;
    int x = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_situer);
        verif = (Button) findViewById(R.id.verifier);
        reponse = (EditText) findViewById(R.id.reponse_situer);
        imageView = (ImageView)findViewById(R.id.tt_carte);
        quest = (TextView) findViewById(R.id.quest);
        layout =(LinearLayout)  findViewById(R.id.lay_color);
        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();
        fileReading();
        verif.setOnClickListener(vrf);
    }

    View.OnClickListener vrf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             value_reponse = reponse.getText().toString();
            if (String.valueOf(value_reponse).equals(rpn))
            {
                verif.setEnabled(false);
                x = 0 ;
                layout.removeView(flech1);
                layout.removeView(phrase1);
                bonne();
            }
            else {
                if(x == 0) {
                    faux();
                }
            }
        }
    };


    View.OnClickListener next_question = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(i == j)
            {
                fin();
            }
            else {
                verif.setEnabled(true);
                reponse.setTextColor(getResources().getColor(R.color.red));
                reponse.setEnabled(true);
                reponse.setText("");
                layout.removeView(flech);
                layout.removeView(phrase);

                i++;
                fileReading();
            }
        }
    };

    public void parseJson(JSONObject response) {
        try {

            JSONObject situer = response.getJSONObject("situer");
            JSONObject exo = situer.getJSONObject(""+i+"");
            while (j< situer.length())
            {
                j++;
            }
            qst = exo.getString("question");
            rpn = exo.getString("reponse");
            quest.setText(qst);
        } catch (Exception e) {
            Log.e("Parsing Error::", e.toString());
            e.printStackTrace();
        }
    }


    public String loadJson() {
        String json = null;
        try {
            InputStream is = getAssets().open("situer.json");
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
    public void faux() {
        x++;
        phrase1 = new TextView(self);
        phrase1.setText("Mauvaise réponse");
        phrase1.setGravity(CENTER);
        phrase1.setTextSize(26);
        phrase1.setTextColor(this.getResources().getColor(R.color.red));
        layout.addView(phrase1);
        flech1 =  new ImageButton(self);
        flech1.setBackgroundResource(R.drawable.faux);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,200);
        params.leftMargin = 400;
        flech1.setLayoutParams(params);
        layout.addView(flech1);
    }
    public void fin() {

        phrase = new TextView(self);
        phrase.setText("Fin du jeu");
        phrase.setGravity(CENTER);
        phrase.setTextSize(26);
        phrase.setTextColor(this.getResources().getColor(R.color.green));
        layout.addView(phrase);

    }

    public void bonne() {
        reponse.setTextColor(this.getResources().getColor(R.color.green));
        reponse.setEnabled(false);
        phrase = new TextView(self);
        phrase.setText("Bonne réponse");
        phrase.setGravity(CENTER);
        phrase.setTextSize(26);
        phrase.setTextColor(this.getResources().getColor(R.color.green));
        layout.addView(phrase);
        flech =  new ImageButton(self);
        flech.setBackgroundResource(R.drawable.flech);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,200);
        params.leftMargin = 400;
        flech.setLayoutParams(params);
        flech.setOnClickListener(next_question);
        layout.addView(flech);
    }
}
