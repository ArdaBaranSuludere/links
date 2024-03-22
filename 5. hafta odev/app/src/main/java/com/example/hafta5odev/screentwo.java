package com.example.hafta5odev;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class screentwo extends AppCompatActivity {
    private LinearLayout mainLayout;
    private int receivedRandomSayi;
    private Handler handler;
    private int sayac = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screentwo);

        // Intent'ten veriyi al
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            receivedRandomSayi = extras.getInt("randomSayi", 0);

            // TextView8'e set et
            TextView textView8 = findViewById(R.id.textView8);
            textView8.setText(String.valueOf(receivedRandomSayi));

            mainLayout = findViewById(R.id.mainLayout);
            handler = new Handler(Looper.getMainLooper());

            changeBackgroundColor();


        }
    }

    private void changeBackgroundColor() {
        int color = getRandomColor();

        mainLayout.setBackgroundColor(color);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sayac < receivedRandomSayi) {
                    changeBackgroundColor();
                    sayac++;
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(screentwo.this, "Bitti!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }, 2000);
    }


    private int getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}