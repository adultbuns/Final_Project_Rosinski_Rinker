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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    static final String URL = "https://markmscott-slapbot-v1.p.rapidapi.com";
    static final String KEY = "1fd185e537msh7414c648afee800p11eb5cjsn84ad689bfa4f";
    static final String HOST = "markmscott-slapbot-v1.p.rapidapi.com";
    static final String SLAPURL = "https://markmscott-slapbot-v1.p.rapidapi.com/Slap?maxrecords=Specifying%20a%20MaxRecords%20against%20the%20MaxRecords%20parameter%20will%20increase%20the%20number%20of%20rows%20returned%20by%20the%20Call%20to%20the%20value%20presented.%20Where%20the%20values%20can%20be%20any%20positive%20number%20less%20than%20or%20equal%20to%2050.%20The%20default%20value%20is%201.";
    static final String CLAPURL = "https://markmscott-slapbot-v1.p.rapidapi.com/Appreciate?maxrecords=10&requirepictures=0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout activity = findViewById(R.id.buttons);
        LinearLayout statusCheck = findViewById(R.id.feedback);
        activity.setVisibility(View.VISIBLE);
        statusCheck.setVisibility(View.GONE);
        //REMOVED: finish();
        //Set up individual buttons.
        Button clap = findViewById(R.id.clap);
        Button slap = findViewById(R.id.slap);
        clap.setOnClickListener(unused -> ifClicked(true));
        slap.setOnClickListener(unused -> ifClicked(false));
        queue = Volley.newRequestQueue(MainActivity.this);
    }

    /**
     * Runs when either clap or slap is clicked.
     * @param clap if clap clicked, else slap
     */
    private void ifClicked(boolean clap) {
        //switches to other layout
        LinearLayout activity = findViewById(R.id.buttons);
        LinearLayout statusCheck = findViewById(R.id.feedback);
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
            JsonArrayRequest clapRequest = new JsonArrayRequest(Request.Method.GET, CLAPURL, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //Work with response JSONArray
                    try {
                        JSONObject obj = response.getJSONObject(0);
                        status.setText(obj.getString("description"));
                        status.setText("GREEN SUCCESS");
                    } catch (JSONException j) {
                        status.setText("GREEN_OOF1");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    status.setText(error.toString());
                }
            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("X-RapidAPI-Key", KEY);
                    params.put("X-RapidAPI-Host", HOST);
                    return params;
                }
            };
            queue.add(clapRequest);
        //The code below should run when lazy button is clicked
        } else {
            //Red background
            statusCheck.setBackgroundColor(Color.RED);
            //Retrieve complement
            JsonArrayRequest slapRequest = new JsonArrayRequest(Request.Method.GET, SLAPURL, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //Work with response JSONArray
                    try {
                        JSONObject obj = response.getJSONObject(0);
                        status.setText(obj.getString("description"));
                        status.setText("RED SUCCESS");
                    } catch (JSONException j) {
                        status.setText("RED_OOF1");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    status.setText("RED_OOF2");
                }
            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("X-RapidAPI-Key", KEY);
                    params.put("X-RapidAPI-Host", HOST);
                    return params;
                }
            };
            queue.add(slapRequest);
        }
    }
}
