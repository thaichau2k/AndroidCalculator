package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Integer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView ResultField;
    int var1=0;
    int var2=0;
    Character operator = null;


    private int[] idButton = {
            R.id.zero, R.id.one, R.id.two, R.id.three,
            R.id.four, R.id.five, R.id.six, R.id.seven,
            R.id.eight, R.id.nine, R.id.dot, R.id.equal,
            R.id.plus, R.id.sub, R.id.multi, R.id.div,
            R.id.C, R.id.CE, R.id.BS, R.id.negative
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ResultField = (TextView) findViewById(R.id.ResultField);
        ResultField.setText("0");
        for (int value : idButton) {
            findViewById(value).setOnClickListener(this);
        }
    }

    private void init() {
        var1 = 0;
        var2 = 0;
        operator = null;
        ResultField.setText("0");
    }

    public void setVar1(){
        var1 = Integer.parseInt(ResultField.getText().toString());
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int data= 0;
        Button b = (Button)v;
        String text = b.getText().toString();
        // check button number
        for (int i = 0; i < idButton.length - 10; i++) {
            if (findViewById(idButton[i]).getId() == v.getId()) {
                if (ResultField.getText() != "0") {
                    ResultField.setText(ResultField.getText() + text);
                } else {
                    ResultField.setText(text);
                }
                if(operator ==null) {
                    var1 = Integer.parseInt(ResultField.getText().toString());
                } else {
                    var2 = Integer.parseInt(ResultField.getText().toString());
                }
            }
        }

        if(v.getId() == R.id.plus) {
            operator = '+';
            ResultField.setText("");

        }
        if(v.getId() == R.id.sub) {
            operator = '-';
            ResultField.setText("");


        }
        if(v.getId() == R.id.multi) {
            operator = 'x';
            ResultField.setText("");


        }
        if(v.getId() == R.id.div) {
            operator = '/';
            ResultField.setText("");

        }
        if(v.getId() == R.id.equal) {
            if(operator!=null) {
                Integer kqua = 0;
                switch (operator) {
                    case '+': kqua = var1 + var2; break;
                    case '-': kqua = var1 - var2; break;
                    case 'x': kqua = var1 * var2; break;
                    case '/': kqua = var1 / var2; break;
                }
                ResultField.setText(kqua.toString());
                var1 = kqua;
                operator = null;
            }
        }

        if(v.getId() == R.id.C) {
            init();
        }

        if(v.getId() == R.id.BS) {
            String s=ResultField.getText().toString();
            if(s.length()<=1)
                ResultField.setText("0");
            else{
                s=s.substring(0,s.length()-1);
                ResultField.setText(s);
            }
        }

        if(v.getId() == R.id.CE) {
            ResultField.setText("0");
        }
    }
}