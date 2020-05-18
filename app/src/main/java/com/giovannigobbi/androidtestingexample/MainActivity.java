package com.giovannigobbi.androidtestingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText operation;
    private TextView textView;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operation = findViewById(R.id.editText);
        textView = findViewById(R.id.txtResult);
        calculator = new Calculator();
        initButtons();
    }

    private void initButtons() {
        List<View> btnsAddText = Arrays.asList(
                findViewById(R.id.btn0), findViewById(R.id.btn1), findViewById(R.id.btn2),
                findViewById(R.id.btn3), findViewById(R.id.btn4), findViewById(R.id.btn5),
                findViewById(R.id.btn6), findViewById(R.id.btn7), findViewById(R.id.btn8),
                findViewById(R.id.btn9), findViewById(R.id.btnPlus), findViewById(R.id.btnMinus),
                findViewById(R.id.btnTimes), findViewById(R.id.btnDivivded), findViewById(R.id.btnPoint));
        for(View v : btnsAddText) {

           v.setOnClickListener(new View.OnClickListener() {
               @SuppressLint("SetTextI18n")
               @Override
               public void onClick(View v) {
                   Button btn = (Button) v;
                   operation.setText(operation.getText().toString() + btn.getText());
               }
           });
        }

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textOperation = operation.getText().toString();
                operation.setText(textOperation.substring(0, textOperation.length() - 1));
            }
        });

        findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(calculator.calculate(operation.getText().toString()));
            }
        });
    }

    private void setText(double result) {
        textView.setText(getString(R.string.result, result + ""));
    }
}
