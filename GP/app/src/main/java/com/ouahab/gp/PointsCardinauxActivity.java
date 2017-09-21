package com.ouahab.gp;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PointsCardinauxActivity extends AppCompatActivity {

    private EditText nord;
    private EditText ouest;
    private EditText est;
    private EditText sud;
    private Button valider;
    private TextView titre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_cardinaux);

        nord = (EditText) findViewById(R.id.nord);
        ouest = (EditText) findViewById(R.id.ouest);
        est = (EditText) findViewById(R.id.est);
        sud = (EditText) findViewById(R.id.sud);

        titre = (TextView) findViewById(R.id.titre);

        setFont(titre, "paris.TTF");

        valider = (Button) findViewById(R.id.valider);

        valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (nord.getText().toString().toUpperCase().equals("N") && ouest.getText().toString().toUpperCase().equals("O") &&
                        est.getText().toString().toUpperCase().equals("E") && sud.getText().toString().toUpperCase().equals("S")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PointsCardinauxActivity.this);
                    builder.setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle(R.string.felicitations)
                            .setMessage(R.string.reussite)
                            .setPositiveButton(R.string.menu, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    PointsCardinauxActivity.this.finish();
                                }
                            })
                            .show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PointsCardinauxActivity.this);
                    builder.setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle(R.string.echec)
                            .setMessage(R.string.erreur)
                            .setPositiveButton(R.string.retour, null)
                            .show();
                }
            }
        });
    }

    public void setFont(TextView textView, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception d) {
                Log.d("FONT", fontName + " introuvable");
            }
        }
    }
}
