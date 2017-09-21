package com.ouahab.gp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

import static android.view.Gravity.CENTER;
import static java.lang.System.out;

public class ExerciceMathsActivity extends AppCompatActivity {

    Context self = this;
    TextView epaclass;
    String nv;
    String ids;
    String text;
    TextView nbr_exo;
    TextView qst;
    String reponse;
    String chaine;
    String question;
    EditText myresponse;
    Button verifier;
    LinearLayout layout;
    TextView phrase;
    ImageButton flech;
    int i = 0;
    int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_maths);
        ids = getIntent().getStringExtra("ids");
        nv = getIntent().getStringExtra("niveau");
        epaclass = (TextView) findViewById(R.id.text);
        layout = (LinearLayout) findViewById(R.id.layout);
        nbr_exo = (TextView) findViewById(R.id.nbr_exo);
        qst = (TextView) findViewById(R.id.question);

        myresponse = (EditText) findViewById(R.id.answer);

        verifier = (Button) findViewById(R.id.verifier);
        verifier.setOnClickListener(verif_btn);

        fileReading();
    }

    public void bonne() {
        phrase = new TextView(self);
        phrase.setText("Bonne réponse");
        phrase.setGravity(CENTER);
        phrase.setTextSize(26);
        phrase.setTextColor(this.getResources().getColor(R.color.green));
        layout.addView(phrase);
        flech =  new ImageButton(self);
        flech.setBackgroundResource(R.drawable.flech);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,200);
        params.leftMargin = 650;
        flech.setLayoutParams(params);
        flech.setOnClickListener(next_question);
        layout.addView(flech);
    }
    public void parseJson1(JSONObject response) {
        try {
            JSONObject exercices = response.getJSONObject("exercices");
            JSONArray niveau = exercices.getJSONArray(nv);

            JSONObject test = niveau.getJSONObject(Integer.parseInt(ids));
            JSONObject exo = test.getJSONObject("exercice");

            JSONArray questions = test.getJSONArray("questions");
            JSONObject nbr_question = questions.getJSONObject(i);

            JSONArray reponses = test.getJSONArray("reponses");
            JSONObject nbr_reponses = reponses.getJSONObject(i);


            question = nbr_question.getString("question"+(i+1));
            reponse =  nbr_reponses.getString("reponse"+(i+1));
            text = exo.getString("text");

            nbr_exo.setText("Exercice " + (Integer.parseInt(ids) +1));
            epaclass.setText(text);
            qst.setText(question);
        } catch (Exception e) {
            Log.e("Parsing Error::", e.toString());
            e.printStackTrace();
        }
    }
    View.OnClickListener next_question = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i++;
            fileReading();
        }
    };

    public void faux() {
        TextView phrase = new TextView(self);
        phrase.setText("Mauvaise réponse");
        phrase.setGravity(CENTER);
        phrase.setTextSize(26);
        phrase.setTextColor(this.getResources().getColor(R.color.red));
        layout.addView(phrase);
        ImageButton flech =  new ImageButton(self);
        flech.setBackgroundResource(R.drawable.faux);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,200);
        params.leftMargin = 650;
        flech.setLayoutParams(params);
        layout.addView(flech);
    }

    public void parseJson(JSONObject response) {
        try {
            JSONObject exercices = response.getJSONObject("exercices");
            JSONArray niveau = exercices.getJSONArray(nv);

            JSONObject test = niveau.getJSONObject(Integer.parseInt(ids));
            JSONObject exo = test.getJSONObject("exercice");

            JSONArray questions = test.getJSONArray("questions");
            JSONObject nbr_question = questions.getJSONObject(0);
            while (j< questions.length())
            {
                j++;
            }
            JSONArray reponses = test.getJSONArray("reponses");
            JSONObject nbr_reponses = reponses.getJSONObject(0);


            question = nbr_question.getString("question1");
            reponse =  nbr_reponses.getString("reponse1");
            text = exo.getString("text");

            nbr_exo.setText("Exercice " + (Integer.parseInt(ids) +1));
            epaclass.setText(text);
            qst.setText(question);

        } catch (Exception e) {
            Log.e("Parsing Error::", e.toString());
            e.printStackTrace();
        }
    }
    View.OnClickListener verif_btn= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            out.println(text);
            out.println(reponse);
            chaine = myresponse.getText().toString();
            out.println(chaine);
            if (String.valueOf(chaine).equals(reponse)) {
                out.println(chaine);
                out.println(reponse);
                bonne();
            }
            else
                faux();
        }
    };
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
            if (i != 0)
            {
                if (i == j)
                {
                    fin();
                    out.println("fin des question");
                }
                else
                    parseJson1(jsonObject);
            }
            else
                parseJson(jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fin() {
        layout.removeView(phrase);
        phrase = new TextView(self);
        phrase.setText("Félicitation l'exercice est fini");
        phrase.setGravity(CENTER);
        phrase.setTextSize(27);
        phrase.setTextColor(this.getResources().getColor(R.color.green));
        layout.addView(phrase);
        layout.removeView(flech);
    }
}
