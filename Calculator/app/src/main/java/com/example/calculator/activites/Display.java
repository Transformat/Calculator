package com.example.calculator.activites;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.calculator.R;
import com.example.calculator.util.AppConstants;
import com.example.calculator.util.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Display extends Activity implements AppConstants {
    ListView listView;
    Spinner spinner;
    List<String> spinnerItems;
    ArrayAdapter spinnerAdapter;
    ArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        listView = (ListView) findViewById(R.id.list_view);
        spinner = (Spinner) findViewById(R.id.spinner_filter);
        spinnerItems = new ArrayList<String>();
        spinnerItems.add("all");
        spinnerItems.add("addition");
        spinnerItems.add("subtraction");
        spinnerItems.add("divide");
        spinnerItems.add("multiply");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case SWITCH_ADD:
                        Collections.reverse(Data.filterHash.get(ADD_SYMBOL));
                        listAdapter = new ArrayAdapter(Display.this, android.R.layout.simple_list_item_1, Data.filterHash.get(ADD_SYMBOL));
                        listAdapter.notifyDataSetChanged();
                        listView.setAdapter(listAdapter);
                        break;
                    case SWITCH_SUBTRACT:
                        Collections.reverse(Data.filterHash.get(SUBTRACT_SYMBOL));
                        listAdapter = new ArrayAdapter(Display.this, android.R.layout.simple_list_item_1, Data.filterHash.get(SUBTRACT_SYMBOL));
                        listAdapter.notifyDataSetChanged();
                        listView.setAdapter(listAdapter);
                        break;
                    case SWITCH_DIVIDE:
                        Collections.reverse(Data.filterHash.get(DIVIDE_SYMBOL));
                        listAdapter = new ArrayAdapter(Display.this, android.R.layout.simple_list_item_1, Data.filterHash.get(DIVIDE_SYMBOL));
                        listAdapter.notifyDataSetChanged();
                        listView.setAdapter(listAdapter);
                        break;
                    case SWITCH_MULTIPLY:
                        Collections.reverse(Data.filterHash.get(MULTIPLY_SYMBOL));
                        listAdapter = new ArrayAdapter(Display.this, android.R.layout.simple_list_item_1, Data.filterHash.get(MULTIPLY_SYMBOL));
                        listAdapter.notifyDataSetChanged();
                        listView.setAdapter(listAdapter);
                        break;
                    case SWITCH_ALL:
                        Collections.reverse(Data.filterHash.get(ALL_VALUES));
                        listAdapter = new ArrayAdapter(Display.this, android.R.layout.simple_list_item_1, Data.filterHash.get(ALL_VALUES));
                        listAdapter.notifyDataSetChanged();
                        listView.setAdapter(listAdapter);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void onClick(View view) {
        Data.allList.clear();
        Data.subtractList.clear();
        Data.addList.clear();
        Data.divideList.clear();
        Data.multiplyList.clear();
        listAdapter.notifyDataSetChanged();
    }


}
