package com.example.android.androidfinalpractical;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by C4Q on 2/25/18.
 */

public class BreedsActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView welcome;
    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";
    HashMap<String, String> breeds;
    private ImageView terrier_pic, spaniel_pic, retriever_pic, poodle_pic;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_breeds);
        welcome=(TextView)findViewById(R.id.welcome);
        terrier_pic=(ImageView)findViewById(R.id.terrier);
        spaniel_pic=(ImageView)findViewById(R.id.spaniel);
        retriever_pic=(ImageView)findViewById(R.id.retriever);
        poodle_pic=(ImageView)findViewById(R.id.poodle);


        CardView terrierCard = findViewById(R.id.terrier_view);
        CardView spanielCard = findViewById(R.id.spaniel_view);
        CardView retrieverCard = findViewById(R.id.retriever_view);
        CardView poodleCard = findViewById(R.id.poodle_view);
        terrierCard.setOnClickListener(this);
        spanielCard.setOnClickListener(this);
        retrieverCard.setOnClickListener(this);
        poodleCard.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", null);


    }

    public void onClick(View view) {
        Intent intent = new Intent(this, DogsActivity.class);

        switch (view.getId()){
            case R.id.terrier_view:
                intent.putExtra("breed", "terrier");
                break;

            case R.id.spaniel_view:
                intent.putExtra("breed", "spaniel");
                break;

            case R.id.retriever_view:
                intent.putExtra("breed", "retriever");
                break;

            case R.id.poodle_view:
                intent.putExtra("breed", "poodle");
                break;

        }
        startActivity(intent);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
