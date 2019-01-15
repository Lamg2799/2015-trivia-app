package com.steam.mytriviaapp;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;



//all of the necessary imports needed//
public class MainActivity extends AppCompatActivity { //extension that is needed//
    Button playGame; //button initialization//
    TextView Title;
    @Override //automatically put in with onCreate//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//xml files it they be linked to to change sizing etc//
                playGame = (Button) findViewById(R.id.playGame);
        Title = (TextView) findViewById(R.id.title1);
        Typeface title = Typeface.createFromAsset(getAssets(), "titlefont.ttf");
        Title.setTypeface(title);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //listens for user to click the button//

                Intent i = new Intent(getApplicationContext(),Categories.class);//opens new categories class window//
startActivity(i);
            }
        })

        ;}
}

