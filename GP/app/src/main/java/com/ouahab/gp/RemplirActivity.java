package com.ouahab.gp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import uk.co.senab.photoview.PhotoViewAttacher;

import static android.view.Gravity.CENTER;
import static java.lang.System.out;

public class RemplirActivity extends AppCompatActivity {
    ImageView imageView;
    TextView lettre;
    TextView phrase;
    ImageView carte;
    ImageButton flech;
    Context self = this;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    LinearLayout layout;
    String rpn;
    String rpn1;
    String rpn2;
    String alpha;
    String reponse;
    String value_button;
    String value_button2;
    String value_button4;
    String value_button3;
    String rpn3;
    int random1;
    int rando;
    int rando1;
    int rando2;
    int rando4;
    int random2;
    int random3;
    int i = 0;
    int j = 0;
    Random rand1 = new Random();
    Random rand2 = new Random();
    Random rand3 = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remplir);
        layout = (LinearLayout) findViewById(R.id.juge);
        carte = (ImageView) findViewById(R.id.carte);
        lettre = (TextView) findViewById(R.id.lettre);
        btn1 = (Button) findViewById(R.id.A);
        btn2 = (Button) findViewById(R.id.B);
        btn3 = (Button) findViewById(R.id.C);
        btn4 = (Button) findViewById(R.id.D);
        btn1.setBackgroundColor(Color.parseColor("#3B81F9"));
        btn2.setBackgroundColor(Color.parseColor("#3B81F9"));
        btn3.setBackgroundColor(Color.parseColor("#3B81F9"));
        btn4.setBackgroundColor(Color.parseColor("#3B81F9"));
        imageView = (ImageView)findViewById(R.id.carte);
        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();
        fileReading();
    }

    public void parseJson(JSONObject response) {
        try {
            random1 = rand1.nextInt(10 - 0 + 1) + 0;
            random2 = rand2.nextInt(10 - 0 + 1) + 0;
            random3 = rand3.nextInt(10 - 0 + 1) + 0;
            while (random2 == i || random2 == random1 || random3 == random2 || random1 == i || random3 == i){
                randomm();
            }
            JSONObject placement = response.getJSONObject("placement");
            JSONObject exo = placement.getJSONObject(""+i+"");
            rpn = exo.getString("reponse");
            alpha = exo.getString("alpha");
            JSONObject ran1 = placement.getJSONObject(""+random1+"");
            JSONObject ran2 = placement.getJSONObject(""+random2+"");
            JSONObject ran3 = placement.getJSONObject(""+random3+"");
            rpn1 = ran1.getString("reponse");
            rpn2 = ran2.getString("reponse");
            rpn3 = ran3.getString("reponse");
            lettre.setText(alpha);
            mon_tableau(rpn,rpn1,rpn2,rpn3);
            btn1.setText(value_button);
            btn2.setText(value_button2);
            btn3.setText(value_button3);
            btn4.setText(value_button4);
            btn1.setOnClickListener(btnClick);
            btn2.setOnClickListener(btnClick2);
            btn3.setOnClickListener(btnClick3);
            btn4.setOnClickListener(btnClick4);
        } catch (Exception e) {
            Log.e("Parsing Error::", e.toString());
            e.printStackTrace();
        }
    }


    public String loadJson() {
        String json = null;
        try {
            InputStream is = getAssets().open("placement.json");
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

    View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fileReading1();
            String btn_reponse = btn1.getText().toString();
            if (btn_reponse.equals(reponse))
            {
                btn1.setBackgroundColor(Color.parseColor("#96CA2D"));
                btn4.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn2.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn3.setBackgroundColor(Color.parseColor("#3B81F9"));
                if(i == 10)
                {
                    phrase = new TextView(self);
                    phrase.setText("Bonne réponse");
                    phrase.setGravity(CENTER);
                    phrase.setTextSize(26);
                    phrase.setTextColor(getResources().getColor(R.color.green));
                    layout.addView(phrase);
                }
                else {
                    bonne();
                    i++;
                }
            }
            else
                btn1.setBackgroundColor(Color.parseColor("#EF0018"));
            out.println(btn_reponse);
            out.println(reponse);
        }
    };

    View.OnClickListener btnClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fileReading1();
            String btn_reponse = btn2.getText().toString();
            if (btn_reponse.equals(reponse))
            {
                btn2.setBackgroundColor(Color.parseColor("#96CA2D"));
                btn4.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn1.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn3.setBackgroundColor(Color.parseColor("#3B81F9"));
                if(i == 10)
                {
                    phrase = new TextView(self);
                    phrase.setText("Bonne réponse");
                    phrase.setGravity(CENTER);
                    phrase.setTextSize(26);
                    phrase.setTextColor(getResources().getColor(R.color.green));
                    layout.addView(phrase);
                }
                else {
                    bonne();
                    i++;
                }
            }
            else
                btn2.setBackgroundColor(Color.parseColor("#EF0018"));
            out.println(btn_reponse);
            out.println(reponse);
        }
    };
    View.OnClickListener btnClick3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fileReading1();
            String btn_reponse = btn3.getText().toString();
            if (btn_reponse.equals(reponse))
            {
                btn3.setBackgroundColor(Color.parseColor("#96CA2D"));
                btn2.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn4.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn1.setBackgroundColor(Color.parseColor("#3B81F9"));
                if(i == 10)
                {
                    phrase = new TextView(self);
                    phrase.setText("Bonne réponse");
                    phrase.setGravity(CENTER);
                    phrase.setTextSize(26);
                    phrase.setTextColor(getResources().getColor(R.color.green));
                    layout.addView(phrase);
                }
                else {
                    bonne();
                    i++;
                }
            }
            else
                btn3.setBackgroundColor(Color.parseColor("#EF0018"));
            out.println(btn_reponse);
            out.println(reponse);
        }
    };

    View.OnClickListener btnClick4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fileReading1();
            String btn_reponse = btn4.getText().toString();
            if (btn_reponse.equals(reponse))
            {
                btn4.setBackgroundColor(Color.parseColor("#96CA2D"));
                btn2.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn3.setBackgroundColor(Color.parseColor("#3B81F9"));
                btn1.setBackgroundColor(Color.parseColor("#3B81F9"));
                if(i == 10)
                {
                    phrase = new TextView(self);
                    phrase.setText("Bonne réponse");
                    phrase.setGravity(CENTER);
                    phrase.setTextSize(26);
                    phrase.setTextColor(getResources().getColor(R.color.green));
                    layout.addView(phrase);
                }
                else {
                    bonne();
                    i++;
                }
            }
            else
                btn4.setBackgroundColor(Color.parseColor("#EF0018"));
            out.println(btn_reponse);
            out.println(reponse);
        }
    };
    public void bonne() {

            int res = getResources().getIdentifier("map" + i, "drawable", this.getPackageName());
            carte.setImageResource(res);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn4.setEnabled(false);
            btn3.setEnabled(false);
            phrase = new TextView(self);
            phrase.setText("Bonne réponse");
            phrase.setGravity(CENTER);
            phrase.setTextSize(26);
            phrase.setTextColor(this.getResources().getColor(R.color.green));
            layout.addView(phrase);
            flech = new ImageButton(self);
            flech.setBackgroundResource(R.drawable.flech);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 200);
            params.leftMargin = 650;
            flech.setLayoutParams(params);
            flech.setOnClickListener(next_question);
            layout.addView(flech);

    }
    View.OnClickListener next_question = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            layout.removeView(phrase);
            layout.removeView(flech);
            btn4.setBackgroundColor(Color.parseColor("#3B81F9"));
            btn2.setBackgroundColor(Color.parseColor("#3B81F9"));
            btn3.setBackgroundColor(Color.parseColor("#3B81F9"));
            btn1.setBackgroundColor(Color.parseColor("#3B81F9"));
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn4.setEnabled(true);
            btn3.setEnabled(true);
            fileReading();
        }
    };
    public void parseJson1(JSONObject response) {
        try {
            JSONObject placement = response.getJSONObject("placement");
            JSONObject exo = placement.getJSONObject(""+i+"");
            reponse = exo.getString("reponse");
        } catch (Exception e) {
            Log.e("Parsing Error::", e.toString());
            e.printStackTrace();
        }
    }
    public void fileReading1() {
        try {
            JSONObject jsonObject = new JSONObject(loadJson());
            parseJson1(jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mon_tableau(String case1,String case2,String case3,String case4)
    {
        String  monTableau [] = {case1, case2,case3,case4};
        rando = rand1.nextInt(3 - 0 + 1) + 0;
        value_button = monTableau[rando];
        monTableau[rando] = null;
        rando1 = rand1.nextInt(3 - 0 + 1) + 0;
        while(monTableau[rando1] == null){
            rando1 = rand1.nextInt(3 - 0 + 1) + 0;
        }
        value_button2 = monTableau[rando1];
        monTableau[rando1] = null;
        rando2 = rand1.nextInt(3 - 0 + 1) + 0;
        while(monTableau[rando2] == null){
            rando2 = rand1.nextInt(3 - 0 + 1) + 0;
        }
        value_button3 = monTableau[rando2];
        //out.println(monTableau[rando2]);
        monTableau[rando2] = null;
        while(monTableau[rando4] == null){
            rando4 = rand1.nextInt(3 - 0 + 1) + 0;
        }
        value_button4 = monTableau[rando4];
        monTableau[rando4] = null;
    }
    public void randomm() {
        random1 = rand1.nextInt(10 - 0 + 1) + 0;
        random2 = rand2.nextInt(10 - 0 + 1) + 0;
        random3 = rand3.nextInt(10 - 0 + 1) + 0;
    }
}
