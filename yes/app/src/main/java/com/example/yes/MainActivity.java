package com.example.yes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    /**
     * Group of buttons to determine state of activity.
     */
    private LinearLayout activity = findViewById(R.id.stuff);
    /**
     * The display of what the user is currently doing. Yeah.
     */
    private LinearLayout statusCheck = findViewById(R.id.status);

    private TextView stateOfDoing = findViewById(R.id.state);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity.setVisibility(View.VISIBLE);
        statusCheck.setVisibility(View.GONE);
        finish();
        //Set up individual buttons.
        Button work = findViewById(R.id.work);
        Button lazy = findViewById(R.id.lazy);
        Button back = findViewById(R.id.back);
        work.setOnClickListener(unused -> ifClicked(true));
        lazy.setOnClickListener(unused -> ifClicked(false));
    }
    private void ifClicked(boolean isClicked) {
        if (isClicked) {
            activity.setVisibility(View.GONE);
            statusCheck.setVisibility(View.VISIBLE);
            statusCheck.setBackgroundColor(Color.GREEN);
        } else {
            activity.setVisibility(View.GONE);
            statusCheck.setVisibility(View.VISIBLE);
            statusCheck.setBackgroundColor(Color.RED);
        }
    }
}
