package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Game;
import game.dice.com.dicegameapp.domain.Player;

public class MainActivity extends AppCompatActivity {


    EditText etName;
    Button button;
    String playerName;
    static GameController gameController= new GameController();



    //-------------
    TextView tv1;

    Button btn;


    boolean hasWon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO move to init() method
        etName=findViewById(R.id.et_name);
        button=findViewById(R.id.btn_main_to_dashboard);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerName=etName.getText().toString();
                //   Player player =new Player(editText.getText().toString());
             gameController.createPlayer(playerName);

                Log.e("player_name",playerName);
                Log.e("controller",gameController.toString());
                Intent i = new Intent(MainActivity.this, Dashboard.class);
                startActivity(i);

            }
        });

        //---------------testing
        tv1=findViewById(R.id.tv1);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Game game1 = new Game();
                Player pl1 = new Player("player1");

                pl1.addGame(game1);
                game1.playGame();

                if (game1.hasWon()){
                    tv1.setText("Congraturations you won!");
                }else {
                    tv1.setText("You have lost");
                }

                Intent i = new Intent(MainActivity.this, Dashboard.class);
                startActivity(i);
            }
        });

    }

    public void initComponent(){

    }

}
