package com.example.luna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class dashboard extends AppCompatActivity {
    //ImageButton imageButton;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        //setupHyperlink();
        //addListenerOnButton();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    //private void setupHyperlink() {
    //    TextView linkTextView = findViewById(R.id.textview1);
    //    linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    //}
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    FourthFragment fourthFragment = new FourthFragment();
    FifthFragment fifthFragment = new FifthFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, firstFragment).commit();
                    return true;
                case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, secondFragment).commit();
                    return true;
                case R.id.messages:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, fourthFragment).commit();
                    return true;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, fifthFragment).commit();
                    return true;
            }
            return false;
        }
    };
    /* public void addListenerOnButton() {

        final Context context = this;

        imageButton = (ImageButton) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, lunaml.class);
                startActivity(intent);

            }

        });

    }*/
}
