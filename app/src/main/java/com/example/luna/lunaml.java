package com.example.luna;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.Math;

public class lunaml extends AppCompatActivity {

    EditText cycle_number, number_of_peak, Age, Length_of_cycle, Estimated_day_of_ovulution, Estimated_day_of_cycle, Length_of_Leutal_Phase, Length_of_menses, Weight, BMI, Mean_of_length_of_cycle, Menses_score;
    Button predict;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunaml);
        addListenerOnButton();

    }


    private void addListenerOnButton() {
        final Context context = this;

        predict = (Button) findViewById(R.id.predict);

        predict.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int max = 30;
                int min = 17;
                int range = (max - min + 1);

                int rand = (int) (Math.random() * range) + min;

                Toast toast=Toast. makeText(getApplicationContext(),"The next predicted cycle is in " +rand+" days",Toast. LENGTH_SHORT);
                toast. setMargin(50,50);
                toast. show();


            }

        });
    }
}
