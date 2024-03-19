package com.example.hafta5odev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int sayi1 = 0, sayi2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buton1 = (Button)findViewById(R.id.button);
        TextView text3 = (TextView)findViewById(R.id.textView3);

        TextView text1 = (TextView)findViewById(R.id.textView);
        TextView text2 = (TextView)findViewById(R.id.textView2);

        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar);
        SeekBar sb2 = (SeekBar) findViewById(R.id.seekBar2);

        sb1.setMax(20);
        sb2.setMax(20);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text1.setText(String.valueOf(progress));
                sayi1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text2.setText(String.valueOf(progress));
                sayi2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ProgressDialog progres= new ProgressDialog(MainActivity.this);
        progres.setCancelable(false);
        progres.setTitle("Diğer sayfaya geçiliyor");
        progres.setMessage("Biraz bekleyin!!.");

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomSayi = getRandomNumber(sayi1, sayi2);
                text3.setText(String.valueOf(randomSayi));
                progres.show();

                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),
                        "İşlem gerçekleşti",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, screentwo.class);
                intent.putExtra("randomSayi", randomSayi);
                startActivity(intent);
            }
        });
    }

    private int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}