package com.example.calculatorappkim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    TextView resultTv,solutionTv;
    MaterialButton buttonC, buttonMultiply,buttonBrackOpen,buttonBrackClose
    , buttonDivide, buttonAdd,buttonMinus,buttonExponent,buttonRoot,buttonEquals, buttonDecimal;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,
            button7,button8,button9;
    private double numInput;
    private ArrayList equation;

    public void numSelected(View v){
        if (v.getId() == R.id.button1){
            Log.i("Esther","Selected1");
            equation.add(1);
        }
        else if (v.getId() == R.id.button2){
            Log.i("Esther","Selected2");
            equation.add(2);
        }
        else if (v.getId() == R.id.button3){
            Log.i("Esther","Selected3");
            equation.add(3);
        }
        else if (v.getId() == R.id.button4){
            Log.i("Esther","Selected4");
            equation.add(4);
        }
        else if (v.getId() == R.id.button5){
            Log.i("Esther","Selected5");
            equation.add(5);
        }
        else if (v.getId() == R.id.button6){
            Log.i("Esther","Selected6");
            equation.add(6);
        }
        else if (v.getId() == R.id.button7){
            Log.i("Esther","Selected7");
            equation.add(7);
        }
        else if (v.getId() == R.id.button8){
            Log.i("Esther","Selected8");
            equation.add(8);
        }
        else if (v.getId() == R.id.button9){
            Log.i("Esther","Selected9");
            equation.add(9);
        }
    }
    public void operatorSelected(View v){
        if (v.getId() == R.id.multiplyButton){
            Log.i("Esther","SelectedMultiply");
            numInput*=numInput;
        }
        else if (v.getId() == R.id.ExponentButton{
            Log.i("Esther","SelectedExponent");
            Math.exp();
        }

    }

    @Override
    public void onClick(View v) {
        
    }
}