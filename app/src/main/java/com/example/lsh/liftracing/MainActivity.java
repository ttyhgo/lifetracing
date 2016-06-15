package com.example.lsh.liftracing;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private static final long REPEAT_TIME = 1000 * 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_button = (Button)findViewById(R.id.start_button);
        Button stop_button = (Button)findViewById(R.id.stop_button);
        Button map_button = (Button)findViewById(R.id.map_button);

        start_button.setOnClickListener(mStartListener);
        stop_button.setOnClickListener(mStopListener);
        map_button.setOnClickListener(mMapListener);

    }

    private final OnClickListener mStartListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            startService(new Intent(MainActivity.this, LocServ.class));
        }
    };

    private final OnClickListener mStopListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            stopService(new Intent(MainActivity.this, LocServ.class));
        }
    };

    private final OnClickListener mMapListener = new OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intentSubActivity =
                    new Intent(MainActivity.this, Map.class);
            startActivity(intentSubActivity);
        }
    };
}