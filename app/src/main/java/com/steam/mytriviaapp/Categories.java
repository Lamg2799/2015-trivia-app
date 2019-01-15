package com.steam.mytriviaapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


//imports needed//
public class Categories extends AppCompatActivity {//extension needed to make an app//
    Button SportsCat;//button created//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categories);//linked to xml file//
        SportsCat = (Button) findViewById(R.id.SportsCat);//^//
        SportsCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//setting a listener for the button click//
                Intent l = new Intent(getApplicationContext(),
                        SportsCat.class);//links to sportscat class//
                startActivity(l);
            }})

        ;}}