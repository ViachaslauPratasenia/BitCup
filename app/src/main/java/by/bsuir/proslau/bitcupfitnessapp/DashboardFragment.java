package by.bsuir.proslau.bitcupfitnessapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardFragment extends Fragment implements View.OnClickListener{
    private Button btnSet;
    private TextView tvPerсent;
    private TextView tvSteps;
    private TextView tvDistance;
    private TextView tvCalories;
    private TextView tvLeftToGo;
    private TextView tvAverage;

    private int preferedSteps = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.dashboard_fragment, container, false);

        btnSet = (Button)view.findViewById(R.id.btn_set_steps);
        tvPerсent = (TextView)view.findViewById(R.id.tv_persent);
        tvDistance = (TextView)view.findViewById(R.id.tv_distance);
        tvCalories = (TextView)view.findViewById(R.id.tv_calories);
        tvLeftToGo = (TextView)view.findViewById(R.id.tv_left_to_go);
        tvAverage = (TextView)view.findViewById(R.id.tv_average);

        btnSet.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Input steps");

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                preferedSteps = Integer.parseInt(input.getText().toString());
                Toast.makeText(getContext(), "Steps = " + preferedSteps, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void setTvPerсent(int perсent) {
        tvPerсent.setText(perсent + "%");
    }

    public void setTvSteps(int steps) {
        tvSteps.setText(steps);
    }

    public void setTvDistance(double distance) {
        tvDistance.setText(distance + "km");
    }

    public void setTvCalories(int calories) {
        tvCalories.setText(calories + "ccal");
    }

    public void setTvLeftToGo() {
        int num = preferedSteps - Integer.parseInt(tvSteps.getText().toString());
        if(num > 0) tvLeftToGo.setText(num);
        else tvLeftToGo.setText(0);
    }

    public void setTvAverage(int average) {
        tvAverage.setText(average);
    }
}
