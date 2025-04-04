package eu.example.pizzastore.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final float price;
    private final String name;
    private List<Ingredients> ingredients;

    public Pizza(float price, String name, List<Ingredients> ingredients) {
        this.price = price;
        this.name = name;
        if (ingredients == null) {
            this.ingredients = new ArrayList<>();
        } else {
            this.ingredients = ingredients;
        }

    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
