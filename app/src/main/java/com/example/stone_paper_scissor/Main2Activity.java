package com.example.stone_paper_scissor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    ImageView stone,paper,scissor;
    TextView playerA,playerB,winner,setName1,setName2,score1,score2,text_round;
    int totalRounds,turn=0,round=0,turnA=0,turnB=0;
    private int scoreA=0,scoreB=0,round_count;
    public static String  player1name,player2name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        stone = findViewById(R.id.stone);
        paper = findViewById(R.id.paper);
        scissor = findViewById(R.id.scissor);

        playerA = findViewById(R.id.playerName1);
        playerB = findViewById(R.id.playerName2);
        winner = findViewById(R.id.winner);
        setName1 = findViewById(R.id.setPlayerName1);
        setName2 = findViewById(R.id.setPlayerName2);
        text_round = findViewById(R.id.text_round);

        Intent intent2 = getIntent();
        player1name = intent2.getStringExtra(MainActivity.Player1);
        player2name = intent2.getStringExtra(MainActivity.Player2);
        totalRounds = intent2.getIntExtra(MainActivity.Rounds,0);

        playerA.setText(player1name);
        playerB.setText(player2name);
        playerB.setAlpha(0.3f);
        setName1.setText(player1name);
        setName2.setText(player2name);

        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);

        score1.setText(Integer.toString(scoreA));
        score2.setText(Integer.toString(scoreB));

        stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0){
                    turnA=1;
                    turn=1;
                    playerA.setAlpha(0.3f);
                    playerB.setAlpha(1.0f);
                }
                else if(turn==1){
                    turnB=1;
                    turn=0;
                    playerA.setAlpha(1.0f);
                    playerB.setAlpha(0.3f);
                    Score();
                }
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0){
                    turnA=2;
                    turn=1;
                    playerA.setAlpha(0.3f);
                    playerB.setAlpha(1.0f);
                }
                else if(turn==1){
                    turnB=2;
                    turn=0;
                    playerA.setAlpha(1.0f);
                    playerB.setAlpha(0.3f);
                    Score();
                }
            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0){
                    turnA=3;
                    turn=1;
                    playerA.setAlpha(0.3f);
                    playerB.setAlpha(1.0f);
                }
                else if(turn==1){
                    turnB=3;
                    turn=0;
                    playerA.setAlpha(1.0f);
                    playerB.setAlpha(0.3f);
                    Score();
                }
            }
        });

        Button retry = findViewById(R.id.retry);
        final Intent intent = new Intent(this,MainActivity.class);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
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
           }
           else if(turnB==3){
               scoreA++;
           }
        }
        else if(turnA==2){
            if(turnB==1){
                scoreA++;
            }
            else if(turnB==3){
                scoreB++;
            }
        }
        else {
            if(turnB==1){
                scoreB++;
            }
            else {
                scoreA++;
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
            playerA.setAlpha(0.3f);
            playerB.setAlpha(0.3f);
            if(scoreA==scoreB){
               winner.setText("Oops! draw");
            }
            else if(scoreA>scoreB){
                winner.setText(player1name + " Wins");
            }
            else {
                winner.setText(player2name + " Wins");
            }
        }
    }
}
