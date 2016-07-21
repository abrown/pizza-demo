package com.example.abrown.pizza;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.abrown.pizza.data.Drink;


public class WidgetHelper {

    static FloatingActionButton goTo(final Activity activity, final Class<? extends Activity> to, @IdRes int button) {
        FloatingActionButton b = (FloatingActionButton) activity.findViewById(button);
        assert b != null;
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(), to);
                activity.startActivity(intent);
            }
        });
        return b;
    }

    static <T> Spinner populateSpinner(final Activity activity, @IdRes int spinnerResource, T[] items){
        ArrayAdapter<T> spinnerArrayAdapter = new ArrayAdapter<>(activity,
                android.R.layout.simple_spinner_item, items);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) activity.findViewById(spinnerResource);
        assert spinner != null;
        spinner.setAdapter(spinnerArrayAdapter);
        return spinner;
    }

    static Integer[] range(int min, int max){
        assert max > min;
        Integer[] list = new Integer[max - min + 1];
        for(int i = 0; i + min <= max; i++){
            list[i] = i + min;
        }
        return list;
    }
}
