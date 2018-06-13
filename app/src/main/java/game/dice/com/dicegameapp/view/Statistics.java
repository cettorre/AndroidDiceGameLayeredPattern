package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;

public class Statistics extends AppCompatActivity {

    ListView recordsList;
    StatsAdapter adapter;
    ArrayList<ResultsRecordDTO> statsAL;
    GameController gameController= new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        initComponents();

        adapter = new StatsAdapter( this, gameController.getResults());
        recordsList.setAdapter(adapter);
        recordsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(Statistics.this,GameView.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });


    }



    public void initComponents(){
        recordsList=findViewById(R.id.lv_records);
    }

}
