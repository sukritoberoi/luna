package com.example.luna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setupHyperlink();
        addListenerOnButton();
    }

    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.textView10);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, dashboard.class);
                startActivity(intent);

            }

        });

}}
