package game.dice.com.dicegameapp.view;

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
    TextView playerName;
   // GameController gameController= new GameController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_new_game=findViewById(R.id.btn_new_game);
        playerName=findViewById(R.id.player_name);

        //TODO use non static instance
        name=MainActivity.gameController.getPlayerName();
        //name=gameController.getPlayerName();//Player.getName()' on a null object reference



        playerName.setText("Hello "+name);

        btn_new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });






    }
}
