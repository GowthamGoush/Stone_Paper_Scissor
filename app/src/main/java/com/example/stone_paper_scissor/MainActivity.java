package com.example.stone_paper_scissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String Player1 = "com.example.stone_paper_scissor_player1";
    public static final String Player2 = "com.example.stone_paper_scissor_player2";
    public static final String Rounds = "com.example.stone_paper_scissor_rounds";
    String player1_text,player2_text;
    int rounds_text;
    TextInputLayout player1Name,player2Name,rounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Name = findViewById(R.id.player1);
        player2Name = findViewById(R.id.player2);
        rounds = findViewById(R.id.rounds);

    }

    public boolean checkInput1(){
        player1_text = Objects.requireNonNull(player1Name.getEditText()).getText().toString().trim();

        if(player1_text.isEmpty()){
            player1Name.setError("Field cannot be empty");
            return false;
        }
        else if(player1_text.length() > 10){
            player1Name.setError("Cannot exceed the limit");
            return false;
        }
        player1Name.setError(null);
        return true;
    }

    public boolean checkInput2(){
        player2_text = Objects.requireNonNull(player2Name.getEditText()).getText().toString().trim();

        if(player2_text.isEmpty()){
            player2Name.setError("Field cannot be empty");
            return false;
        }
        else if(player2_text.length() > 10){
            player2Name.setError("Cannot exceed the limit");
            return false;
        }
        player2Name.setError(null);
        return true;
    }

    public boolean checkInput3(){
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

    public void startGame(View v){
        boolean a,b,c;
        a = checkInput1();
        b = checkInput2();
        c = checkInput3();
        if(a && b && c) {
            final Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra(MainActivity.Player1, player1_text);
            intent.putExtra(MainActivity.Player2, player2_text);
            intent.putExtra(MainActivity.Rounds, rounds_text);
            startActivity(intent);
        }
    }
}
