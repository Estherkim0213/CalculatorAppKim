package com.example.calculatorappkim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

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
    ArrayList<String> equationArray = new ArrayList<String>();
    private double variable;
    boolean hasDecimal = false;
    boolean hasOp;

    public void numSelected(View v) {
        String buttonText = "";
        if (v.getId() == R.id.button0) {
            Log.i("Esther", "Selected0");
            buttonText += 0;
        } else if (v.getId() == R.id.button1) {
            Log.i("Esther", "Selected1");
            buttonText += 1;
        } else if (v.getId() == R.id.button2) {
            Log.i("Esther", "Selected2");
            buttonText += 2;
        } else if (v.getId() == R.id.button3) {
            Log.i("Esther", "Selected3");
            buttonText += 3;
        } else if (v.getId() == R.id.button4) {
            Log.i("Esther", "Selected4");
            buttonText += 4;
        } else if (v.getId() == R.id.button5) {
            Log.i("Esther", "Selected5");
            buttonText += 5;
        } else if (v.getId() == R.id.button6) {
            Log.i("Esther", "Selected6");
            buttonText += 6;
        } else if (v.getId() == R.id.button7) {
            Log.i("Esther", "Selected7");
            buttonText += 7;
        } else if (v.getId() == R.id.button8) {
            Log.i("Esther", "Selected8");
            buttonText += 8;
        } else if (v.getId() == R.id.button9) {
            Log.i("Esther", "Selected9");
            buttonText += 9;
        } else if (v.getId() == R.id.decimalButton
                && hasDecimal == false) {
            Log.i("Esther", "SelectedDecimal");
            equation += ".";
            hasDecimal = true;
        } else if (v.getId() == R.id.eButton) {
            Log.i("Esther", "SelectedButtonE");
            variable = 2.718282;
            equation += "e";
        } else if (v.getId() == R.id.piButton) {
            Log.i("Esther", "SelectedButtonPi");
            variable = 3.141593;
            equation += "π";
        }
        equation += buttonText;
        if (equation.length() < 15) {
            resultTv.setText(equation);
        }
        hasOp = true;
    }

    public void operatorSelected(View v) {
        if (equation.length() != 0&& hasOp == true) {
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
            } else if (v.getId() == R.id.divideButton) {
                Log.i("Esther", "SelectedDivide");
                equation += "÷";
            }
        }
        if (v.getId() == R.id.SquareRootButton) {
            Log.i("Esther", "SelectedRoot");
            equation += "√";
        }
        if (v.getId() == R.id.backButton && equation.length()>0) {
            Log.i("Esther", "SelectedBack");
            equation = equation.substring(0, equation.length() - 1);
        }
        if (equation.length() < 15) {
            resultTv.setText(equation);
        }
        if (v.getId() == R.id.clearButton) {
            Log.i("Esther", "SelectedClear");
            equation = "";
            equationArray.clear();
            resultTv.setText("0");
        }
        if (v.getId() == R.id.equalsButton) {
            Log.i("Esther", "SelectedEqual");
            solutionTv.setText(resultTv.getText());
            createInt(equation);
            resultTv.setText(calculation(equationArray));
            equation = "";
            equationArray.clear();
        }
        hasOp = false;
        hasDecimal = false;
    }

    /**cite:https://www.baeldung.com/java-c
     * heck-string-number#:~:text=3.-,Using%20Plain%20Java,parseInt(String)
     */
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
    public static boolean isDouble(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //creates Array by checking each number of equation
    public void createInt(String data) {
        Log.i("Esther", "eq: " + equation);
        String num = "";
        double value;
        int x = 0;
        for (int i = 0; i < data.length(); i++) {
            if (isInt(String.valueOf(data.charAt(i)))) {
                num += data.charAt(i);
            }
            if (isInt(String.valueOf(data.charAt(i))) == false
                    || i +1 == data.length()) {
                if(data.charAt(i) == ('.')){
                    num += data.charAt(i);
                }
                else if (String.valueOf(data.charAt(i)).equals("π")
                        || String.valueOf(data.charAt(i)).equals("e")) {
                    if(num != "") {
                        equationArray.add(num);
                        equationArray.add("×");
                    }
                    equationArray.add(String.valueOf(variable));
                    num = "";
                } else {
                    equationArray.add(num);
                    if (i +1 != data.length()){
                        equationArray.add(String.valueOf(data.charAt(i)));
                    }

                    Log.i("Esther", "i: " + equationArray);
                    num = "";
                }
            }
        }
        Log.i("Esther", "ea: " + equationArray);
    }


    //Does calculations (order of operations)
    public String calculation(ArrayList<String> data) {
        String answer;
        double num1 = 0;
        double num2 = 0;
        for (int i = 0; i < data.size(); i++) {
            if ((String.valueOf(data.get(i)).equals("^")
                    || String.valueOf(data.get(i)).equals("√"))) {
                if (String.valueOf(data.get(i)).equals("^")) {
                    num1 = Double.parseDouble(data.get(i - 1));
                    num2 = Double.parseDouble(data.get(i + 1));
                    data.set(i-1,String.valueOf(Math.pow(num1, num2)));
                } else if (String.valueOf(data.get(i)).equals("√")) {
                    if (isDouble(String.valueOf(data.get(i - 1)))) {
                        num1 = Double.parseDouble(data.get(i - 1));
                    } else {
                        num1 = 1;
                    }
                    num2 = Double.parseDouble(data.get(i + 1));
                    data.set(i-1,String.valueOf(num1 * Math.sqrt(num2)));
                }
                data.remove(i);
                data.remove(i);
                num1 = 0;
                num2 = 0;
                i--;
            }
        }
        for (int i = 0; i < data.size(); i++) {
            if (isDouble(String.valueOf(data.get(i))) == false
                    && String.valueOf(data.get(i)).equals("÷")
                    || String.valueOf(data.get(i)).equals("×")) {
                if (String.valueOf(data.get(i)).equals("÷")) {
                    num1 = Double.parseDouble(data.get(i - 1));
                    num2 = Double.parseDouble(data.get(i + 1));
                    data.set(i-1,String.valueOf(num1 / num2));
                } else if (String.valueOf(data.get(i)).equals("×")) {
                    num1 = Double.parseDouble(data.get(i - 1));
                    num2 = Double.parseDouble(data.get(i + 1));
                    Log.i("Esther", "its in mult");
                    data.set(i-1,String.valueOf(num1 * num2));
                }
                data.remove(i);
                data.remove(i);
                Log.i("Esther", "mult value: " + data.get(i-1));
                num1 = 0;
                num2 = 0;
                i--;
            }
        }
        for (int i = 0; i < data.size(); i++) {
            if (isDouble(String.valueOf(data.get(i))) == false
                    && String.valueOf(data.get(i)).equals("+")
                    ||String.valueOf(data.get(i)).equals("-")) {
                num1 = Double.parseDouble(data.get(i - 1));
                if(data.get(i + 1).equals("null")){
                    num2 = 0;
                }
                else{
                    num2 = Double.parseDouble(data.get(i + 1));
                }
                Log.i("Esther", "n1:"+String.valueOf(num1));
                Log.i("Esther","n2:"+ String.valueOf(num2));
                if (String.valueOf(data.get(i)).equals("+")) {
                    Log.i("Esther", "its in add");
                    data.set(i-1,String.valueOf(num1 + num2));
                } else if (String.valueOf(data.get(i)).equals("-")) {
                    data.set(i-1, String.valueOf(num1 - num2));
                }
                Log.i("Esther", "add value: " + data.get(i-1));
                data.remove(i);
                data.remove(i);
                num1 = 0;
                num2 = 0;
                i--;
            }

        }
        answer = data.get(0);
        return answer;
    }
    //done!

}