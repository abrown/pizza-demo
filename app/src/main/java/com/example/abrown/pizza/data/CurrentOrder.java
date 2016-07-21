package com.example.abrown.pizza.data;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class CurrentOrder {
    private static final CurrentOrder instance = new CurrentOrder();
    private List<Buyable> data = new ArrayList<>();

    public static CurrentOrder getInstance() {
        return instance;
    }

    public List<Buyable> items() {
        return data;
    }

    public <T extends Buyable> List<T> itemsOfType(Class<T> type) {
        return Lists.newArrayList(Iterables.filter(items(), type));
    }

    public float price() {
        float price = 0;
        for (Buyable b : items()) {
            price += b.price();
        }
        return price;
    }
}
