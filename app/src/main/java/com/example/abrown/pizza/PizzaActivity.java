package com.example.abrown.pizza;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.abrown.pizza.data.Drink;
import com.example.abrown.pizza.data.Pizza;

public class PizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // populate spinners
        WidgetHelper.populateSpinner(this, R.id.sizeSpinner, Pizza.Size.values());
        WidgetHelper.populateSpinner(this, R.id.quantitySpinner, WidgetHelper.range(1, 15));
        WidgetHelper.populateCheckboxes(this, R.id.toppingsTable, Pizza.Toppings.values());

        // link buttons
        WidgetHelper.goTo(this, DrinkActivity.class, R.id.drinkButton);
        WidgetHelper.goTo(this, ConfirmActivity.class, R.id.payButton);
        WidgetHelper.goTo(this, PizzaActivity.class, R.id.pizzaButton);
    }
}
