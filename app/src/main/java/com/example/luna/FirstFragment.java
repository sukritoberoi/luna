package com.example.luna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    private View v;
    public FirstFragment() {

        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_first, container, false);
        setupHyperlink();
        configureImageButton();
        return v;
    }

    private void setupHyperlink() {
        TextView linkTextView = v.findViewById(R.id.textview1);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void configureImageButton() {
        ImageButton btn = (ImageButton) v.findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view_tag, new lunapredict());
                fragmentTransaction.commit();
            }
        });
    }

}