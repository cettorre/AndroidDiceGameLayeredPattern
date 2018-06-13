package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;

public class FinalScore extends AppCompatActivity {

    TextView tvFinalScore;
    GameController gameController= new GameController();
    Button btnResumeGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        initComponents();

        tvFinalScore.setText(String.format("%.2f",gameController.getTotalAverage())+"%");

        btnResumeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FinalScore.this,GameView.class);
                startActivity(i);
            }
        });
    }

    private void initComponents(){
        tvFinalScore=findViewById(R.id.tv_finalScore);
        btnResumeGame=findViewById(R.id.btn_resume_game);
    }
}
