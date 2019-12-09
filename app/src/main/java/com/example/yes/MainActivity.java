package com.example.yes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    static final String URL= "https://markmscott-slapbot-v1.p.rapidapi.com";
    static final String KEY = "1fd185e537msh7414c648afee800p11eb5cjsn84ad689bfa4f";
    static final String HOST = "markmscott-slapbot-v1.p.rapidapi.com";
    /**
     * Group of buttons to determine state of activity.
     */
    private LinearLayout activity = findViewById(R.id.buttons);
    /**
     * The display of what the user is currently doing. Yeah.
     */
    private LinearLayout statusCheck = findViewById(R.id.feedback);

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
     * @param clap if clap clicked, else slap
     */
    private void ifClicked(boolean clap) {
        //switches to other layout
        activity.setVisibility(View.GONE);
        statusCheck.setVisibility(View.VISIBLE);
        //Set up this page
        TextView status = findViewById(R.id.state);
        Button back = findViewById(R.id.back);
        //Back button swaps views
        back.setOnClickListener(unused -> {
            activity.setVisibility(View.VISIBLE);
            statusCheck.setVisibility(View.GONE);
        });
        //The code below should run when working is clicked
        if (clap) {
            //Green background
            statusCheck.setBackgroundColor(Color.GREEN);
            //Retrieve complement
            JsonArrayRequest clapRequest = new JsonArrayRequest(Request.Method.GET, URL + "/Appreciate", null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //Work with response JSONArray
                    try {
                        JSONObject obj = response.getJSONObject(0);
                        status.setText(obj.getString("description"));
                    } catch (JSONException j) {

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("X-RapidAPI-Key", KEY);
                    params.put("X-RapidAPI-Host", HOST);
                    return params;
                }
            };
        //The code below should run when lazy button is clicked
        } else {
            //Red background
            statusCheck.setBackgroundColor(Color.RED);
            //Retrieve complement
            JsonArrayRequest slapRequest = new JsonArrayRequest(Request.Method.GET, URL + "/Slap", null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //Work with response JSONArray
                    try {
                        JSONObject obj = response.getJSONObject(0);
                        status.setText(obj.getString("description"));
                    } catch (JSONException j) {

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("X-RapidAPI-Key", KEY);
                    params.put("X-RapidAPI-Host", HOST);
                    return params;
                }
            };
        }
    }
}
