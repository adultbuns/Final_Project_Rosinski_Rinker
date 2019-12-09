package com.example.yes;

/**
import android.net.Uri;
import android.util.Log;

import android.widget.TextView;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
*/
public class Generate {
    /**
}
    static final String URL= "https://markmscott-slapbot-v1.p.rapidapi.com";
    static final String KEY = "1fd185e537msh7414c648afee800p11eb5cjsn84ad689bfa4f";
    static final String HOST = "markmscott-slapbot-v1.p.rapidapi.com";
    /**
     *
     * @return the Web API insult
     *
    public static String webInsult() {

        /**
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String uri = Uri.parse(API_BASE).buildUpon().build().toString();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("MainActivity", "response: " + response);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", error.toString());
            }

        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("X-Mashape-Key", "<API_KEY>");
                params.put("Accept", "text/plain");
                return params;
            }
        };
        requestQueue.add(stringRequest);
         */
/**
        JsonArrayRequest slapRequest = new JsonArrayRequest(Request.Method.GET, URL + "/Slap", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Work with response JSONArray
                try {
                    JSONObject obj = response.getJSONObject(0);
                    final String OUT = obj.getString("description");
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

    /**
     *
     * @return the Web API complement
     *
    public static String webComplement() {
        String out = "Generated Complement";
        return out;
    }

    /**
     *
     * @return a big set of text. the complement will be part of it.
     *
    public static String complementBlock() {
        return webComplement();
    }

    /**
     *
     * @return a block of text. the complement will be part of it.
     *
    public static String insultBlock() {
        return webInsult();
    }
*/
}
