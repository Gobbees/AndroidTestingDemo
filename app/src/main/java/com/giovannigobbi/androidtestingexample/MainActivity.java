package com.giovannigobbi.androidtestingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText operation;
    TextView txtResult;
    TextView txtLastResult;

    Calculator calculator;

    SharedPreferences sharedPreferences;

    private String lastResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operation = findViewById(R.id.editText);
        txtResult = findViewById(R.id.txtResult);
        txtResult.setText(getString(R.string.result, ""));
        txtLastResult = findViewById(R.id.txtLastResult);
        sharedPreferences = getSharedPreferences("MainActivity", Context.MODE_PRIVATE);
        setLastResult();
        calculator = new Calculator();
        initButtons();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void setLastResult() {
        lastResult = sharedPreferences.getString("lastResult", "");
        txtLastResult.setText(getString(R.string.last_result, lastResult));
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
                if (textOperation.length() > 0) {
                    operation.setText(textOperation.substring(0, textOperation.length() - 1));
                }
            }
        });

        findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double result = calculator.calculate(operation.getText().toString());
                    setText(result);
                    setLastResult();
                    operation.setText("");
                    lastResult = result.toString();
                    sharedPreferences.edit().putString("lastResult", lastResult).commit();
                } catch (InvalidOperationException ex) {
                    showErrorToast();
                }
            }
        });
    }

    private void setText(double result) {
        txtResult.setText(getString(R.string.result, result + ""));
    }

    private void showErrorToast() {
        Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
    }
}
