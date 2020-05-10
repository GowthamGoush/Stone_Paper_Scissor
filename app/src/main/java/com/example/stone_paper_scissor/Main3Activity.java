package com.example.stone_paper_scissor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {
    Random rnd = new Random();
    int random_num;
    int totalRounds,turn=0,round=0,turnA=0,turnB=0;
    private int scoreA=0,scoreB=0,round_count;
    TextView winner,setName,score1,score2,text_round;
    ImageView stone,paper,scissor;
    RelativeLayout relativeLayout;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        score1 = findViewById(R.id.score_bot);
        score2 = findViewById(R.id.score_you);
        winner = findViewById(R.id.winner2);
        text_round = findViewById(R.id.text_round_2);
        setName = findViewById(R.id.setPlayerName);

        Intent getName = getIntent();
        setName.setText(getName.getStringExtra(Main4Activity.Player));
        totalRounds = getName.getIntExtra(Main4Activity.Rounds_2,0);

        relativeLayout = findViewById(R.id.single_player_bg);

        botPlay();

        stone = findViewById(R.id.stone_2);
        paper = findViewById(R.id.paper_2);
        scissor = findViewById(R.id.scissor_2);

        stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==1){
                    turnB=1;
                    turn=0;
                    Score();
                    botPlay();
                }
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==1){
                    turnB=2;
                    turn=0;
                    Score();
                    botPlay();
                }
            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==1){
                    turnB=3;
                    turn=0;
                    Score();
                    botPlay();
                }
            }
        });

        Button retry = findViewById(R.id.retry_2);
        final Intent intent3 = new Intent(this,Main5Activity.class);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                relativeLayout.setBackgroundResource(R.drawable.ic_background2);
            }
        };
    }

    public void botPlay(){
       random_num = rnd.nextInt(2);

       if(random_num==0){
           Stone();
       }
       else if(random_num==1){
           Paper();
       }
       else {
           Scissor();
       }
    }

    public void Stone(){
        if(turn==0){
            turnA=1;
            turn=1;
        }
    }
    public void Paper(){
        if(turn==0){
            turnA=2;
            turn=1;
        }
    }
    public void Scissor(){
        if(turn==0){
            turnA=3;
            turn=1;
        }
    }

    @SuppressLint("SetTextI18n")
    public void Score(){
        if((turnA==1 && turnB==1) || (turnA==2 && turnB==2) || (turnA==3 && turnB==3)){
            scoreA++;
            scoreB++;
        }
        else if(turnA==1){
            if(turnB==2){
                scoreB++;
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                countDownTimer.start();
            }
            else if(turnB==3){
                scoreA++;
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                countDownTimer.start();
            }
        }
        else if(turnA==2){
            if(turnB==1){
                scoreA++;
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                countDownTimer.start();
            }
            else if(turnB==3){
                scoreB++;
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                countDownTimer.start();
            }
        }
        else {
            if(turnB==1){
                scoreB++;
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                countDownTimer.start();
            }
            else {
                scoreA++;
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                countDownTimer.start();
            }
        }
        score1.setText(Integer.toString(scoreA));
        score2.setText(Integer.toString(scoreB));
        round++;
        if(round!=totalRounds) {
            round_count = round + 1;
            text_round.setText("Round " + round_count);
        }
        if(round==totalRounds){
            turn=3;
            if(scoreA==scoreB){
                winner.setText("Oops! draw");
            }
            else if(scoreA>scoreB){
                winner.setText("You loose !");
            }
            else {
                winner.setText("You Win !");
            }
        }
    }
}
