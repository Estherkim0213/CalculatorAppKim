package com.example.calculatorappkim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView resultTv, solutionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.OutputView);
        solutionTv = findViewById(R.id.inputView);
        solutionTv.setText("0");
        resultTv.setText("0");
    }


    private String equation = "";
    private int buttonSelected;
    private double variable;
    private static int[] intArray;

    public void numSelected(View v) {
        if (v.getId() == R.id.button1) {
            Log.i("Esther", "Selected1");
            buttonSelected = 1;
        } else if (v.getId() == R.id.button2) {
            Log.i("Esther", "Selected2");
            buttonSelected = 2;
        } else if (v.getId() == R.id.button3) {
            Log.i("Esther", "Selected3");
            buttonSelected = 3;
        } else if (v.getId() == R.id.button4) {
            Log.i("Esther", "Selected4");
            buttonSelected = 4;
        } else if (v.getId() == R.id.button5) {
            Log.i("Esther", "Selected5");
            buttonSelected = 5;
        } else if (v.getId() == R.id.button6) {
            Log.i("Esther", "Selected6");
            buttonSelected = 6;
        } else if (v.getId() == R.id.button7) {
            Log.i("Esther", "Selected7");
            buttonSelected = 7;
        } else if (v.getId() == R.id.button8) {
            Log.i("Esther", "Selected8");
            buttonSelected = 8;
        } else if (v.getId() == R.id.button9) {
            Log.i("Esther", "Selected9");
            buttonSelected = 9;
        } else if (v.getId() == R.id.eButton) {
            Log.i("Esther", "SelectedButtonE");
            variable = 2.718281828459045;
            equation += "e";
        } else if (v.getId() == R.id.piButton) {
            Log.i("Esther", "SelectedButtonPi");
            variable = 3.141592653589793;
            equation += "π";
        }
        equation += buttonSelected;
        if (equation.length() < 15) {
            resultTv.setText(equation);
        }
    }

    public void operatorSelected(View v) {
        if (v.getId() == R.id.multiplyButton) {
            Log.i("Esther", "SelectedMultiply");
            equation += "×";
        } else if (v.getId() == R.id.ExponentButton) {
            Log.i("Esther", "SelectedExponent");
            equation += "^";
        } else if (v.getId() == R.id.minusButton) {
            Log.i("Esther", "SelectedMinus");
            equation += "-";
        } else if (v.getId() == R.id.addButton) {
            Log.i("Esther", "SelectedAdd");
            equation += "+";
        } else if (v.getId() == R.id.RightParenthesesButton) {
            Log.i("Esther", "SelectedRightBracket");
            equation += ")";
        } else if (v.getId() == R.id.LeftParenthesesButton) {
            Log.i("Esther", "SelectedLeftBracket");
            equation += "(";
        } else if (v.getId() == R.id.divideButton) {
            Log.i("Esther", "SelectedDivide");
            equation += "÷";
        }
        else if (v.getId() == R.id.SquareRootButton) {
            Log.i("Esther", "SelectedRoot");
            equation += "√";
        }
        else if (v.getId() == R.id.backButton) {
            Log.i("Esther", "SelectedBack");
            equation = equation.substring(0,equation.length()-1);
        }
        if (equation.length() < 15) {
            resultTv.setText(equation);
        }
        if (v.getId() == R.id.clearButton) {
            Log.i("Esther", "SelectedClear");
            equation = "";
            resultTv.setText("0");
        }if (v.getId() == R.id.equalsButton) {
            Log.i("Esther", "SelectedEqual");
            intArray = new int[equation.length()];
            solutionTv.setText(resultTv.getText());
            createInt(equation);
            resultTv.setText(calculations(equation));
        }
    }

    public static boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void createInt(String data) {
        String num = "";
        int value;
        int x = 0;
        for (int i = 0; i < data.length()-1; i++) {
            if (isInt(String.valueOf(data.substring(i,i+1)))){
                Log.i("Esther", "kuldeep was not");
                num += data.charAt(i);
                Log.i("Esther", num);
            } else if((data.substring(i,i+1).equals('+')
            || data.substring(i,i+1).equals("-")
            || data.substring(i,i+1).equals("^")
            || data.substring(i,i+1).equals("×")
            || data.substring(i,i+1).equals("(")
            || data.substring(i,i+1).equals(")")
            ||data.substring(i,i+1).equals("÷")
            ||data.substring(i,i+1).equals("√")
            ||data.substring(i,i+1).equals("."))) {
                Log.i("Esther", "kuldeep");
                value = Integer.valueOf(num);
                intArray[x] = value;
                x++;
                num = "";
            }
        }
    }

    public String calculations(String data) {
        int x = 0;
        double calculate = 0;
        String outPut= "";

        for (int i = 0; i < data.length()-1; i++) {
            if (isInt(String.valueOf(data.charAt(i))) == false) {
                Log.i("Esther", "kuldeep was here");
                if (String.valueOf(data.charAt(i))=="+"){
                    calculate = intArray[x] + intArray[x + 1];
                    Log.i("Esther", "kuldeep wasnt here");

                }
                else if (String.valueOf(data.charAt(i))=="-"){
                    calculate = intArray[x] - intArray[x + 1];
                    Log.i("Esther", outPut);

                }
                x++;
            }
        }
        outPut = String.valueOf(calculate);

        Log.i("Esther", outPut);
        return outPut;
    }
}