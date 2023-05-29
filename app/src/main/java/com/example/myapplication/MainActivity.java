package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    SeekBar seekBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //дата в когда началось сегодняшняя
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        textView = (TextView)findViewById(R.id.textViewDAt);
        String dateText = dateFormat.format(currentDate);
        textView.setText(dateText);

        //добавить ко вкладу
        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               TextView Text1 = (TextView) findViewById(R.id.editTextPhone);
               String Skoka = Text1.getText().toString();
               int Skosaint = Integer.parseInt(Skoka);

                TextView Text2 = (TextView) findViewById(R.id.textViewSumma);
                String skokabilo = Text2.getText().toString();
                int Skokabiloint = Integer.parseInt(skokabilo);
                int proc = (Skokabiloint/100)*Skosaint;
                int raschet = (Skokabiloint + proc);
                Text2.setText(String.valueOf(raschet));
            }
        });
        //суть сиик бара
        seekBar = (SeekBar)findViewById(R.id.seekBarSumma);
        textView = (TextView)findViewById(R.id.textViewSumma);
        //изменение текста сверху
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(""+ String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //расчет итоговый
        Button raschetbut = (Button) findViewById(R.id.buttonRaschet);
        raschetbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView Text = (TextView) findViewById(R.id.editTextPhone2);
                String Itog = Text.getText().toString();
                int Itogo = Integer.parseInt(Itog);

                TextView Text2 = (TextView) findViewById(R.id.textViewSumma);
                String skokabilo = Text2.getText().toString();
                int Skokabiloint = Integer.parseInt(skokabilo);

                int raschet =  Itogo * Skokabiloint;
                TextView Itoge = (TextView) findViewById(R.id.textViewItog);

                Itoge.setText(String.valueOf(raschet));


            }
        });

    }
}