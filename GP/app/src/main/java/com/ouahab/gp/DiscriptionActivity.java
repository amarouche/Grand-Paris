package com.ouahab.gp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ouahab.gp.Exercices.exercice;
import com.ouahab.gp.Exercices.exercice_difficile;
import com.ouahab.gp.Exercices.exercice_normal;

import java.util.ArrayList;
import java.util.Random;

public class DiscriptionActivity extends AppCompatActivity {

    private Button facile, normal, difficile;

    private long counter = 10;

    private Button answer1, answer2, answer3, answer4;
    private TextView score, question, countdown;

    private Questions mQuestions = new Questions();

    ArrayList limit = new ArrayList();

    private int test;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.myQuestions.length;

    private int victory = mQuestionsLength;

    private int j = 0;

    private Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discription);

        facile = (Button) findViewById(R.id.facile);
        normal = (Button) findViewById(R.id.normal);
        difficile = (Button) findViewById(R.id.difficile);

        facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), exercice.class);
                startActivity(intent);

            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), exercice_normal.class);
                startActivity(intent);

            }
        });

        difficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), exercice_difficile.class);
                startActivity(intent);

            }
        });
    }
}
