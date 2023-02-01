package com.example.luna;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class lunapredict extends Fragment {

    private View v;

    public lunapredict() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_lunapredict, container, false);
        configureImageButton();
        return v;
    }

    private void configureImageButton() {
        Button btn = (Button) v.findViewById(R.id.predict);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int max = 30;
                int min = 17;
                int range = (max - min + 1);

                int rand = (int) (Math.random() * range) + min;

                Toast toast=Toast. makeText(getActivity(),"The next predicted cycle is in " +rand+" days",Toast. LENGTH_SHORT);
                toast. setMargin(50,50);
                toast. show();

            }
        });
    }
}