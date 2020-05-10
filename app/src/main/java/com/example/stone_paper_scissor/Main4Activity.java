package com.example.stone_paper_scissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Main4Activity extends AppCompatActivity {

    public static final String Player = "com.example.stone_paper_scissor_player";
    public static final String Rounds_2 = "com.example.stone_paper_scissor_rounds_2";
    TextInputLayout playerName,rounds;
    String player_text;
    int rounds_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        playerName = findViewById(R.id.player_2);
        rounds = findViewById(R.id.rounds_2);
    }

    public boolean checkInput1(){
        player_text = Objects.requireNonNull(playerName.getEditText()).getText().toString().trim();

        if(player_text.isEmpty()){
            playerName.setError("Field cannot be empty");
            return false;
        }
        else if(player_text.length() > 10){
            playerName.setError("Cannot exceed the limit");
            return false;
        }
        playerName.setError(null);
        return true;
    }

    public boolean checkInput2(){
        if(rounds.getEditText().getText().toString().isEmpty()){
            rounds.setError("Field cannot be empty");
            return false;
        }

        rounds_text = Integer.parseInt(Objects.requireNonNull(rounds.getEditText()).getText().toString().trim());

        if(rounds_text==0 || rounds_text>100){
            rounds.setError("Enter a number between 1-100");
            return false;
        }
        rounds.setError(null);
        return true;
    }

    public void startGame_2(View v){
        boolean a,b;
        a = checkInput1();
        b = checkInput2();
        if(a && b) {
            final Intent intent2 = new Intent(this, Main3Activity.class);
            intent2.putExtra(Main4Activity.Player, player_text);
            intent2.putExtra(Main4Activity.Rounds_2, rounds_text);
            startActivity(intent2);
        }

    }
}
