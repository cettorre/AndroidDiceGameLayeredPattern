package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Game;
import game.dice.com.dicegameapp.domain.Player;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameView extends AppCompatActivity {

    Button btnPlay;
    TextView tvDice1;
    TextView tvDice2;
    TextView tvResult;
    Button btnEndGame;
    boolean hasWon;
    GameController gameController= new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        initComponents();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hasWon=gameController.playGame();

                if (hasWon){
                    tvResult.setText("Congratulations you win!");
                }else {
                    tvResult.setText("You have lost. Try Again.");
                }

                tvDice1.setText(String.valueOf(gameController.getDice1Value()));

                tvDice2.setText(String.valueOf(gameController.getDice2Value()));
            }
        });

        btnEndGame.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(GameView.this, Score.class);
            startActivity(i);
            }
        });
    }

    public void initComponents(){
        btnPlay=findViewById(R.id.btn_play);
        tvDice1=findViewById(R.id.tv_dice1);
        tvDice2=findViewById(R.id.tv_dice2);
        tvResult=findViewById(R.id.tv_result);
        btnEndGame=findViewById(R.id.btn_end_game);
    }

}
