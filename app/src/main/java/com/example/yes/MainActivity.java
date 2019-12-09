package com.example.yes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Group of buttons to determine state of activity.
     */
    private LinearLayout activity = findViewById(R.id.buttons);
    /**
     * The display of what the user is currently doing. Yeah.
     */
    private LinearLayout statusCheck = findViewById(R.id.feedback);

    private TextView stateOfDoing = findViewById(R.id.state);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity.setVisibility(View.VISIBLE);
        statusCheck.setVisibility(View.GONE);
        finish();
        //Set up individual buttons.
        Button clap = findViewById(R.id.clap);
        Button slap = findViewById(R.id.slap);
        clap.setOnClickListener(unused -> ifClicked(true));
        slap.setOnClickListener(unused -> ifClicked(false));
    }

    /**
     * Runs when either clap or slap is clicked.
     * @param working
     */
    private void ifClicked(boolean clap) {
        //switches to other layout
        activity.setVisibility(View.GONE);
        statusCheck.setVisibility(View.VISIBLE);
        //Set up this page
        TextView status = findViewById(R.id.state);
        Button back = findViewById(R.id.back);
        //Back button swaps viewa
        back.setOnClickListener(unused -> {
            activity.setVisibility(View.VISIBLE);
            statusCheck.setVisibility(View.GONE);
        });
        //The code below should run when working is clicked
        if (clap) {
            //Green background
            statusCheck.setBackgroundColor(Color.GREEN);
            //Retrieve complement
            status.setText(Generate.complementBlock());
        //The code below should run when lazy button is clicked
        } else {
            //Red background
            statusCheck.setBackgroundColor(Color.RED);
            //Retrieve complement
            status.setText(Generate.insultBlock());
        }
    }
}
