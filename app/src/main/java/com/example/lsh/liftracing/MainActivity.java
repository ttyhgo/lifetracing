package com.example.lsh.liftracing;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_button = (Button)findViewById(R.id.start_button);
        Button stop_button = (Button)findViewById(R.id.stop_button);

        start_button.setOnClickListener(mStartListener);
        stop_button.setOnClickListener(mStopListener);

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
}