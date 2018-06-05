package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.ResultsRecord;

public class Statistics extends AppCompatActivity {

    ListView recordsList;
    GameController gameController= new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);


        ArrayAdapter<ResultsRecord> adapter = new ArrayAdapter<>(
                this, android.R.layout.two_line_list_item,gameController.getResults());

        recordsList.setAdapter(adapter);

    }

    public void initComponents(){
        recordsList=findViewById(R.id.lv_records);
    }

}
