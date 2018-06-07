package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;

public class Dashboard extends AppCompatActivity {

    String name;
    Button btnNewGame;
    Button btnShowStats;
    Button btnChangePlayer;
    TextView playerName;
    GameController gameController= new GameController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initComponents();

        name=gameController.getPlayerName();

        playerName.setText("Hello "+name);

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Dashboard.this, GameView.class);
                startActivity(i);
            }
        });

        btnShowStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, Statistics.class);
                startActivity(i);
            }
        });

        btnChangePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void initComponents(){
        btnNewGame =findViewById(R.id.btn_new_game);
        btnShowStats =findViewById(R.id.btn_show_stats);
        playerName=findViewById(R.id.player_name);
        btnChangePlayer=findViewById(R.id.btn_change_player);
    }
}
