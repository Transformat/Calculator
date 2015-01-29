package com.example.calculator.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.util.AppConstants;
import com.example.calculator.util.Data;


public class MainPage extends Activity implements AppConstants {
    EditText editNumber1;
    EditText editNumber2;
    EditText editResult;
    Float num1;
    Float num2;
    Float result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Data.filterHash.put(ADD_SYMBOL, Data.addList);
        Data.filterHash.put(SUBTRACT_SYMBOL, Data.subtractList);
        Data.filterHash.put(DIVIDE_SYMBOL, Data.divideList);
        Data.filterHash.put(MULTIPLY_SYMBOL, Data.multiplyList);
        Data.filterHash.put(ALL_VALUES, Data.allList);

        setContentView(R.layout.activity_main_page);
        editNumber1 = (EditText) findViewById(R.id.edit_num1);
        editNumber2 = (EditText) findViewById(R.id.edit_num2);
        editResult = (EditText) findViewById(R.id.edit_result);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                if (editNumber1.getText().toString().equals("") || editNumber2.getText().toString().equals("")) {
                    Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Float.parseFloat(editNumber1.getText().toString());
                    num2 = Float.parseFloat(editNumber2.getText().toString());
                    result = num1 + num2;
                    editResult.setText(result.toString());
                    String historyStringAdd = editNumber1.getText().toString() + ADD_SYMBOL + editNumber2.getText().toString() + EQUAL_SYMBOL + result.toString();
                    Data.addList.add(historyStringAdd);
                    Data.allList.add(historyStringAdd);

                    break;
                }
            case R.id.button_subtract:
                if (editNumber1.getText().toString().equals("") || editNumber2.getText().toString().equals("")) {
                    Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Float.parseFloat(editNumber1.getText().toString());
                    num2 = Float.parseFloat(editNumber2.getText().toString());
                    result = num1 - num2;
                    editResult.setText(result.toString());
                    String historyStringSubtract = editNumber1.getText().toString() + SUBTRACT_SYMBOL + editNumber2.getText().toString() + EQUAL_SYMBOL + result.toString();
                    Data.subtractList.add(historyStringSubtract);
                    Data.allList.add(historyStringSubtract);

                }
                break;
            case R.id.button_divide:
                if (editNumber1.getText().toString().equals("") || editNumber2.getText().toString().equals("")) {
                    Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (editNumber2.getText().toString().equals("0")) {
                        Toast.makeText(this, "Second field cannot be Zero", Toast.LENGTH_SHORT).show();
                    } else {
                        num1 = Float.parseFloat(editNumber1.getText().toString());
                        num2 = Float.parseFloat(editNumber2.getText().toString());
                        result = num1 / num2;
                        editResult.setText(result.toString());
                        String historyStringDivide = editNumber1.getText().toString() + DIVIDE_SYMBOL + editNumber2.getText().toString() + EQUAL_SYMBOL + result.toString();
                        Data.divideList.add(historyStringDivide);
                        Data.allList.add(historyStringDivide);

                    }
                }
                break;
            case R.id.button_multiply:
                if (editNumber1.getText().toString().equals("") || editNumber2.getText().toString().equals("")) {
                    Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Float.parseFloat(editNumber1.getText().toString());
                    num2 = Float.parseFloat(editNumber2.getText().toString());
                    result = num1 * num2;
                    editResult.setText(result.toString());
                    String historyStringMultiply = editNumber1.getText().toString() + MULTIPLY_SYMBOL + editNumber2.getText().toString() + EQUAL_SYMBOL + result.toString();
                    Data.multiplyList.add(historyStringMultiply);
                    Data.allList.add(historyStringMultiply);

                }
                break;
            case R.id.button_summary:
                Intent intent =new Intent(this,Display.class);
                startActivity(intent);
            default:
                break;
        }
    }


}
