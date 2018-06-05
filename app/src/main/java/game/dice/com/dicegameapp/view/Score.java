package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;

public class Score extends AppCompatActivity {


    TextView rolledTimes;
    TextView victories;
    Button btnDashboard;
    GameController gameController= new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        initComponents();

        //rolledTimes.setText();


        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Score.this, Dashboard.class);
                startActivity(i);
            }
        });





    }

    public void initComponents(){
        rolledTimes=findViewById(R.id.rolled_times);
        victories=findViewById(R.id.victories_percent);
        btnDashboard=findViewById(R.id.btn_dashboard);


    }

}
