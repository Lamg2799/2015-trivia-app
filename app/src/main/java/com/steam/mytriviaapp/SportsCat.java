package com.steam.mytriviaapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;
import android.os.CountDownTimer;
import android.content.Intent;
//necessary imports//
public class SportsCat extends AppCompatActivity {//extension needed for app//
    TextView Question;//new textview variable to show the random question//
    Button Choice1;//new button variable for answers//
    Button Choice2;//^//
    Button Choice3;//^//
    Button Choice4;//^//
    TextView SecondsLeft;//new textview variable//
    int QuestionCounter =0;//question counter int set to 0//
    public static Integer Points = 0;// points set/reset to 0 depending on if it isfirst game since it was opened //
    boolean[] numbers = new boolean [4];//new boolean array with 4 numbers and areauto set to false, then later if true, they cannot be used, so it will not use samequestion//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_cat);//all of these linked to theirrespective xml variable to change sizing etc//
        SecondsLeft = (TextView) findViewById(R.id.SecondsLeft);
        Question = (TextView) findViewById(R.id.MainQuestion);

        Choice1 = (Button) findViewById(R.id.Question1);
        Choice2 = (Button) findViewById(R.id.Question2);
        Choice3 = (Button) findViewById(R.id.Choice3);
        Choice4 = (Button) findViewById(R.id.Choice4);
        Log.d("firstThing","yuh1");
        Body();
    }
    public void Body() {//new object//
        Log.d("firstThing2","yuh1");
        String[] ArraySportsQuestions = {"Which NBA team holds the record for the most season wins in the Eastern Conference in history?", "Which of these soccer players has won the most FIFA Ballon d'Ors after 2010?", "Since what year was table tennis an Olympic sport?", "Which of these athletes had a video game made in honour of him?", "How many national sports does Canada have?"};//questions to be used//
        final String[] ArraySportsQ1 = {"Boston Celtics", "Miami Heat", "Chicago Bulls", "Cleveland Cavaliers"};//question answers//
        final String[] ArraySportsQ2 = {"Lionel Messi", "Cristiano Ronaldo", "Neymar",
"Luis Suarez"};
        final String[] ArraySportsQ3 = {"1988", "1974", "1984", "1996"};
        final String[] ArraySportsQ4 = {"Shaun White", "Micheal Jordan", "Lionel Messi", "Shaun Federer"};
        final String[] ArraySportsQ5 = {"2", "1", "3", "4"};
        String[][] arrayofQs = {ArraySportsQ1, ArraySportsQ2, ArraySportsQ3, ArraySportsQ4, ArraySportsQ5};//2D array//
        QuestionCounter++;
        Random gen = new Random();//new random generator gen//
        int num = gen.nextInt(4);
        while(numbers[num])//makes sure it is not the same number//
        {
            num = gen.nextInt(4);
        }
        numbers[num] = true;
        ArrayList<Integer> orderlist = new ArrayList<>();
        for(int i=0;i<=3;i++)
        {
            orderlist.add(new Integer(i));
        }
        Collections.shuffle(orderlist);
        int x = orderlist.get(0);
        int y = orderlist.get(1);
        int z = orderlist.get(2);
        int u = orderlist.get(3);
        Typeface font2 = Typeface.createFromAsset(getAssets(), "subway.ttf");
        Question.setTypeface(font2);
        Question.setText(ArraySportsQuestions[num]);//randomising of questions andanswers//
        Choice1.setText(arrayofQs[num][x]);//sets the answer to the set for thequestion, for example is num = 3, answer set 3, and then the buttons below to randomstrings in this inner array//
        Choice2.setText(arrayofQs[num][y]);
        Choice3.setText(arrayofQs[num][z]);
        Choice4.setText(arrayofQs[num][u]);
        Log.d("secondThing","bool: "+numbers[num]);

        new CountDownTimer(10000, 1000) {
            int secondsLeft = 0;
            public void onTick(long ms) {
                if (Math.round((float)ms / 1000.0f) != secondsLeft)
                {
                    secondsLeft = Math.round((float)ms / 1000.0f);
                    SecondsLeft.setText("seconds remaining: " +secondsLeft );
                }
            }

            public void onFinish() {
                SecondsLeft.setText("0");
                Body();
            }
        }.start();
        Choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("fifth thing done","on click");
                if(Choice1.getText().equals(ArraySportsQ1[1])||Choice1.getText().equals(ArraySportsQ2[
                        1]) || Choice1.getText().equals(ArraySportsQ3[1]) ||
                        Choice1.getText().equals(ArraySportsQ4[1]) ||
                        Choice1.getText().equals(ArraySportsQ5[1]))// these are the answers//
                {
                    Points++;
                    Toast.makeText(SportsCat.this, "Correct!" ,
                    Toast.LENGTH_LONG).show();//a notification type message at the bottom of the screendisappearing after//
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else{
                        Body();
                    }
                }else
                {
                    Toast.makeText(SportsCat.this, "Incorrect" ,
                    Toast.LENGTH_LONG).show();
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else
                    {
                        Body();
                    }
                }

            }
        });
        Choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice1.getText().equals(ArraySportsQ1[1])||Choice1.getText().equals(ArraySportsQ2[
                        1]) || Choice1.getText().equals(ArraySportsQ3[1]) ||
                        Choice1.getText().equals(ArraySportsQ4[1]) ||
                        Choice1.getText().equals(ArraySportsQ5[1]))
                {Points++;
                    Toast.makeText(SportsCat.this, "Correct!" ,
                    Toast.LENGTH_LONG).show();
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else{
                        Body();
                    }
                }else
                {
                    Toast.makeText(SportsCat.this, "Incorrect" ,
                    Toast.LENGTH_LONG).show();
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else{
                        Body();
                    }
                }
            }
        });
        Choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice1.getText().equals(ArraySportsQ1[1])||Choice1.getText().equals(ArraySportsQ2[
                        1]) || Choice1.getText().equals(ArraySportsQ3[1]) ||
                        Choice1.getText().equals(ArraySportsQ4[1]) ||
                        Choice1.getText().equals(ArraySportsQ5[1]))
                {Points++;
                    Toast.makeText(SportsCat.this, "Correct!" ,
                    Toast.LENGTH_LONG).show();
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else{
                        Body();
                    }
                }else
                {
                    Toast.makeText(SportsCat.this, "Incorrect" ,
                    Toast.LENGTH_LONG).show();
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else{

                        Body();
                    }
                }
            }
        });
        Choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice1.getText().equals(ArraySportsQ1[1])||Choice1.getText().equals(ArraySportsQ2[
                        1]) || Choice1.getText().equals(ArraySportsQ3[1]) ||
                        Choice1.getText().equals(ArraySportsQ4[1]) ||
                        Choice1.getText().equals(ArraySportsQ5[1]))
                {Points++;
                    Toast.makeText(SportsCat.this, "Correct!" ,
                    Toast.LENGTH_LONG).show();
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else{
                        Body();
                    }}else
                {
                    Toast.makeText(SportsCat.this, "Incorrect" ,
                    Toast.LENGTH_LONG).show();
                    if(QuestionCounter==4)
                    {
                        Intent j = new Intent(getApplicationContext(),gamedone.class);
                        startActivity(j);
                    }else{
                        Body();
                    }
                    Toast.makeText(SportsCat.this, "Incorrect" ,
                    Toast.LENGTH_LONG).show();
                }
            }
        });

    }}
    