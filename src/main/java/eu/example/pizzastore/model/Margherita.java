package eu.example.pizzastore.model;

import java.util.List;

public class Margherita extends Pizza {
    public Margherita(float price, List<Ingredients> ingredients) {
        super(price, "Margherita", ingredients);
        if(ingredients == null ) {
            getIngredients().add(Ingredients.tomato);
            getIngredients().add(Ingredients.mozzarella);
        }
    }
}
