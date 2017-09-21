package com.ouahab.gp.Exercices;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ouahab.gp.MainActivity;
import com.ouahab.gp.Questions;
import com.ouahab.gp.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Idir on 04/05/2017.
 */

public class exercice_difficile extends AppCompatActivity {


    private long counter = 60;

    private Button answer1, answer2, answer3, answer4;
    private TextView score, question, countdown;

    private Questions mQuestions = new Questions();

    ArrayList limit = new ArrayList();

    private int test;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.myQuestions.length;

    private int j = 0;

    private Random r;

    private int time = 90000;

    private int badAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_difficile);

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        countdown = (TextView) findViewById(R.id.countdown);

        score.setText("Score: " + mScore);
        test = r.nextInt(mQuestionsLength);
        updateQuestions(test);

        new CountDownTimer(time, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                countdown.setText("Secondes restantes: " + millisUntilFinished / 1000);
                counter--;
            }

            @Override
            public void onFinish() {
                if (mScore < 9)
                    gameOver();
            }
        }.start();



        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    test = r.nextInt(mQuestionsLength);
                    if (mScore < 9)
                        updateQuestions(test);
                    else
                        victoire();
                } else {
                    badAnswers++;
                    if (badAnswers == 3)
                        gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    test = r.nextInt(mQuestionsLength);
                    if (mScore < 9)
                        updateQuestions(test);
                    else
                        victoire();
                } else {
                    badAnswers++;
                    if (badAnswers == 3)
                        gameOver();
                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    test = r.nextInt(mQuestionsLength);
                    if (mScore < 9)
                        updateQuestions(test);
                    else
                        victoire();
                } else {
                    badAnswers++;
                    if (badAnswers == 3)
                        gameOver();
                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    test = r.nextInt(mQuestionsLength);
                    if (mScore < 9)
                        updateQuestions(test);
                    else
                        victoire();
                } else {
                    badAnswers++;
                    if (badAnswers == 3)
                        gameOver();
                }

            }
        });

    }

    public void updateQuestions(int i) {

        counter = 10;
        while (limit.contains(i)) {
            i = r.nextInt(mQuestionsLength);
        }

        question.setText(mQuestions.getQuestion(i));
        answer1.setText(mQuestions.getChoice1(i));
        answer2.setText(mQuestions.getChoice2(i));
        answer3.setText(mQuestions.getChoice3(i));
        answer4.setText(mQuestions.getChoice4(i));

        mAnswer = mQuestions.getCorrectAnswer(i);
        limit.add(i);
    }


    private void victoire() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(exercice_difficile.this);
        alertDialogBuilder
                .setMessage("Tu as gagné !!!")
                .setCancelable(false)
                .setPositiveButton("Recommencer",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(exercice_difficile.this);
        alertDialogBuilder
                .setMessage("Tu as perdu! Ton score est de " + mScore + " points")
                .setCancelable(false)
                .setPositiveButton("Recommencer",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
