package com.steam.mytriviaapp;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;



//necessary imports//
public class gamedone extends AppCompatActivity {//extension for app to work//
    TextView gameDone;//new textview variable//
    Button BackToMain;//new button variable//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamedone);//variables and such being linked to an xmlfile to change sizing etc//
        gameDone = (TextView) findViewById(R.id.gameDone);
        BackToMain = (Button) findViewById(R.id.BackToMain);
        gameDone.setText("Game finished, your score was " + SportsCat.Points);
        BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(getApplicationContext(),
                        MainActivity.class);//sends you back to main menu//
                startActivity(h);
            }
        })

        ;}}