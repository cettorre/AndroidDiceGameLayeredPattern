package game.dice.com.dicegameapp.view;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;
import game.dice.com.dicegameapp.persistence.DbHelper;
import game.dice.com.dicegameapp.persistence.DbUtil;

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

        rolledTimes.setText("You have rolled the dices "+String.valueOf(gameController.getRolledTimes())+" times");

        victories.setText(String.format("%.2f",(gameController.getPlayer().getPlayerRanking()))+"% of victories ");

        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Score.this, Dashboard.class);
                startActivity(i);

                //simplified passing methods to ResultRecord constructor
                ResultsRecordDTO record=gameController.createRecord();
                gameController.addRecordToList(record);//TODO
                /*
                * usar records que hay en player o dto
                * añadirlo durante gameview
                *
                * */

                gameController.resetGamesList();
                Log.e("results_list",gameController.getResults().toString());


            }
        });
    }

    public void initComponents(){
        rolledTimes=findViewById(R.id.rolled_times);
        victories=findViewById(R.id.victories_percent);
        btnDashboard=findViewById(R.id.btn_dashboard);
    }
}
