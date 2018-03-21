package com.working4enjoyment.simplecarlos;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contador= 0;

        final TextView textBattery= findViewById(R.id.textBattery);


        //Dividir por cero
        final Button buttonZero = findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SystemClock.sleep(5000);
              contador= 0;

              contador= contador/0;

            }
        });

        //Sumar 1 2.000 veces
        final Button buttonThousand = findViewById(R.id.buttonThousand);
        buttonThousand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contador=0;

                buttonThousand.setText("Pass");
                SystemClock.sleep(2000);
                for(int i=0; i<2000; i++){
                    contador++;


                }


            }
        });

        //Sumar 1 2.000.000 veces
        final Button buttonMillion = findViewById(R.id.buttonMillion);
        buttonMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contador=0;

                buttonMillion.setText("Pass");

                SystemClock.sleep(6000);

                for(int i=0; i<2000000; i++) {
                    contador++;

                }






            }
        });


        //Bateria
        final Button buttonBattery = findViewById(R.id.buttonBattery);
        buttonBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonBattery.setText("Pass");

                IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                Intent batteryStatus = getApplicationContext().registerReceiver(null, ifilter);

                int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

                float batteryPct = (level / (float)scale) * 100;

                textBattery.setText(batteryPct+"%");

                SystemClock.sleep(3000);

            }
        });

    }
}
