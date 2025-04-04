package eu.example.pizzastore.service;

import eu.example.pizzastore.model.Pizza;

import java.util.UUID;

public class Order {
    private String pizzaId;
    private final Pizza pizza;
    private boolean pizzaReady = false;

    public Order(Pizza pizza) {
        this.pizza = pizza;
        this.pizzaId = UUID.randomUUID().toString();
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public boolean isPizzaReady() {
        return pizzaReady;
    }

    public void setPizzaReady(boolean pizzaReady) {
        this.pizzaReady = pizzaReady;
    }
}
