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
    Button btn_new_game;
    Button btn_show_stats;
    TextView playerName;
    GameController gameController= new GameController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initComponents();

        name=gameController.getPlayerName();

        playerName.setText("Hello "+name);

        btn_new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Dashboard.this, GameView.class);
                startActivity(i);
            }
        });

        btn_show_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, Statistics.class);
                startActivity(i);
            }
        });

    }

    public void initComponents(){
        btn_new_game=findViewById(R.id.btn_new_game);
        btn_show_stats=findViewById(R.id.btn_show_stats);
        playerName=findViewById(R.id.player_name);
    }
}
