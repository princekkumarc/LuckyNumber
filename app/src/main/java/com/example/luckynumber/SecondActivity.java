package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeText, luckyNumberText;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeText = findViewById(R.id.textView2);
        luckyNumberText = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_btn);


        //Receiving the data from Main Activity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        //generating random number
        int random_num= generatingRandomNumber();
        luckyNumberText.setText(""+random_num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, random_num);
            }
        });

    }
    public  int generatingRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated =  random.nextInt(upper_limit);
        return randomNumberGenerated;
    }
    public  void  shareData(String userName, int randomNum){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, userName+ "get lucky today");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is:" +randomNum);
        startActivity(Intent.createChooser(intent, "Choose a platform"));
    }
}