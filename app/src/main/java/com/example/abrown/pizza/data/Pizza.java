package com.example.abrown.pizza.data;

import com.example.abrown.pizza.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pizza implements Buyable {

    public enum Size {Small, Medium, Large}

    public enum Toppings {Tomato, Cheese, Peppers, Onions, Sausage, Ham, Chicken}

    static Map<Size, Float> sizePrices = new HashMap<>();
    Size selectedSize = Size.Medium;
    static Map<Toppings, Float> toppingsPrices = new HashMap<>();
    Set<Toppings> selectedToppings = new HashSet<>();

    static{
        sizePrices.put(Size.Small, 5.0f);
        sizePrices.put(Size.Medium, 10.0f);
        sizePrices.put(Size.Large, 15.0f);

        toppingsPrices.put(Toppings.Tomato, 0.0f);
        toppingsPrices.put(Toppings.Cheese, 0.0f);
        toppingsPrices.put(Toppings.Peppers, 0.0f);
        toppingsPrices.put(Toppings.Onions, 0.0f);
        toppingsPrices.put(Toppings.Sausage, 1.0f);
        toppingsPrices.put(Toppings.Ham, 1.0f);
        toppingsPrices.put(Toppings.Chicken, 1.0f);
    }

    public Pizza(Size size, Toppings... toppings) {
        selectedSize = size;
        selectedToppings.addAll(Arrays.asList(toppings));
    }

    public Size size() {
        return selectedSize;
    }

    public void size(Size size) {
        selectedSize = size;
    }

    public Set<Toppings> toppings() {
        return selectedToppings;
    }

    public void addTopping(Toppings topping) {
        selectedToppings.add(topping);
    }

    public void removeTopping(Toppings topping) {
        selectedToppings.remove(topping);
    }

    @Override
    public String name() {
        return size() + " Pizza (" + toppings() + ")";
    }

    @Override
    public int icon() {
        return R.drawable.ic_local_pizza_white_24dp;
    }

    @Override
    public float price() {
        float price = sizePrices.get(selectedSize);
        for (Toppings t : selectedToppings) {
            price += toppingsPrices.get(t);
        }
        return price;
    }
}
