package com.example.calculatorappkim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numSelected(View v){
        double numInput = 0;
        if (v.getId() == R.id.button1){
            Log.i("Esther","Selected1");
            numInput = 1;
        }
        else if (v.getId() == R.id.button2){
            Log.i("Esther","Selected2");
            numInput = 2;
        }
        else if (v.getId() == R.id.button3){
            Log.i("Esther","Selected3");
            numInput = 3;
        }
        else if (v.getId() == R.id.button4){
            Log.i("Esther","Selected4");
            numInput = 4;
        }
        else if (v.getId() == R.id.button5){
            Log.i("Esther","Selected5");
            numInput = 5;
        }
        else if (v.getId() == R.id.button6){
            Log.i("Esther","Selected6");
            numInput = 6;
        }
        else if (v.getId() == R.id.button7){
            Log.i("Esther","Selected7");
            numInput = 7;
        }
        else if (v.getId() == R.id.button8){
            Log.i("Esther","Selected8");
            numInput = 8;
        }
        else if (v.getId() == R.id.button9){
            Log.i("Esther","Selected9");
            numInput = 9;
        }
    }
}