package com.example.calculatorappkim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{



    TextView resultTv,solutionTv;
//    MaterialButton buttonC, buttonMultiply,buttonBrackOpen,buttonBrackClose
//    , buttonDivide, buttonAdd,buttonMinus,buttonExponent,buttonRoot,buttonEquals, buttonDecimal;
//    MaterialButton button0,button1,button2,button3,button4,button5,button6,
//            button7,button8,button9;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        resultTv = findViewById(R.id.OutputView);
//        solutionTv = findViewById(R.id.inputView);
//    }
//
//    void assignId(MaterialButton btn, int id){
//        btn = findViewById(id);
//        btn.setOnClickListener(this);
//        numSelected();
//    }

    private double numInput;
    private String equation;
    private double buttonSelected;

    public void numSelected(View v){
        if (v.getId() == R.id.button1){
            Log.i("Esther","Selected1");
            buttonSelected = 1;
        }
        else if (v.getId() == R.id.button2){
            Log.i("Esther","Selected2");
            buttonSelected = 2;
        }
        else if (v.getId() == R.id.button3){
            Log.i("Esther","Selected3");
            buttonSelected = 3;
        }
        else if (v.getId() == R.id.button4){
            Log.i("Esther","Selected4");
            buttonSelected = 4;
        }
        else if (v.getId() == R.id.button5){
            Log.i("Esther","Selected5");
            buttonSelected = 5;
        }
        else if (v.getId() == R.id.button6){
            Log.i("Esther","Selected6");
            buttonSelected = 6;
        }
        else if (v.getId() == R.id.button7){
            Log.i("Esther","Selected7");
            buttonSelected = 7;
        }
        else if (v.getId() == R.id.button8){
            Log.i("Esther","Selected8");
            buttonSelected = 8;
        }
        else if (v.getId() == R.id.button9){
            Log.i("Esther","Selected9");
            buttonSelected = 9;
        }
        else if (v.getId() == R.id.eButton){
            Log.i("Esther","SelectedButtonE");
            buttonSelected = 2.718281828459045;
        }
        else if (v.getId() == R.id.piButton){
            Log.i("Esther","SelectedButtonPi");
            buttonSelected =  3.141592653589793;
        }
        equation += buttonSelected;
        solutionTv.setText(equation);
    }
    public void operatorSelected(View v){
        if (v.getId() == R.id.multiplyButton){
            Log.i("Esther","SelectedMultiply");
            equation += "*";
        }

        else if (v.getId() == R.id.ExponentButton){
            Log.i("Esther","SelectedExponent");
            equation += "^";
        }
        else if (v.getId() == R.id.minusButton){
            Log.i("Esther","SelectedMinus");
            equation += "-";
        }
        else if (v.getId() == R.id.addButton){
            Log.i("Esther","SelectedAdd");
            equation += "+";
        }
        else if (v.getId() == R.id.RightParenthesesButton){
            Log.i("Esther","SelectedRightBracket");
            equation += ")";
        }
        else if (v.getId() == R.id.LeftParenthesesButton){
            Log.i("Esther","SelectedLeftBracket");
            equation += "(";
        }


    }


}