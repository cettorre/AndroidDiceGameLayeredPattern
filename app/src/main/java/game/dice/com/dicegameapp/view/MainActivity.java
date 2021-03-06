package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnGoToDashBoard;
    String playerName;
    GameController gameController= new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btnGoToDashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            playerName=etName.getText().toString();

            if(!android.text.TextUtils.isDigitsOnly(playerName.trim())&&playerName!=null) {
                gameController.createPlayer(playerName);
                Intent i = new Intent(MainActivity.this, Dashboard.class);
                startActivity(i);
            }else {
                Toast t= Toast.makeText(MainActivity.this,"please enter a valid player name",Toast.LENGTH_LONG);
                t.show();
            }
            }
        });

    }

    public void initComponents(){
        etName=findViewById(R.id.et_name);
        btnGoToDashBoard =findViewById(R.id.btn_main_to_dashboard);
    }

}
