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
    GameController gameController= new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            playerName=etName.getText().toString();
            gameController.createPlayer(playerName);              //  Log.e("player_name",playerName);Log.e("controller",gameController.toString());
            Intent i = new Intent(MainActivity.this, Dashboard.class);
            startActivity(i);

            }
        });

    }

    public void initComponents(){
        etName=findViewById(R.id.et_name);
        button=findViewById(R.id.btn_main_to_dashboard);
    }

}
