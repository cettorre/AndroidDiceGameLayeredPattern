package game.dice.com.dicegameapp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;

public class StatsAdapter  extends ArrayAdapter<ResultsRecordDTO> {

    private Context context;
    private List<ResultsRecordDTO> stats;

    public StatsAdapter(@NonNull Context context, List<ResultsRecordDTO> stats) {
        super(context, R.layout.record_adapter,stats);
        this.context = context;
        this.stats = stats;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater =
                (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View messageView = inflater.inflate(R.layout.record_adapter,parent,false);

        TextView name = (TextView) messageView.findViewById(R.id.tv_name_list);
        TextView rolledTimes = (TextView) messageView.findViewById(R.id.tv_rolled_times_list);
        TextView victories = (TextView) messageView.findViewById(R.id.tv_victories_list);

        name.setText(this.stats.get(position).getPlayerName());
        rolledTimes.setText(String.valueOf(this.stats.get(position).getNumberOfRolls()));
        victories.setText(String.format("%.2f",(this.stats.get(position).getPercentageOfVictories()))+"%");

        return messageView;
    }

}

