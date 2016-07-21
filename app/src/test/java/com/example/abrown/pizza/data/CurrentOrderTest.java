package com.example.abrown.pizza.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrentOrderTest {
    @Test
    public void basicUsage() {
        CurrentOrder order = CurrentOrder.getInstance();
        assertEquals(0, order.items().size());

        order.items().add(new Pizza(Pizza.Size.Medium, Pizza.Toppings.Tomato, Pizza.Toppings.Cheese, Pizza.Toppings.Sausage));
        order.items().add(new Drink(Drink.Size.Small, Drink.Flavor.Coke));
        assertEquals(2, order.items().size());

        assertEquals(13.0, order.price(), 0.0);
    }
}