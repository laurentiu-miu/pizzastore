package eu.example.pizzastore.model;

import java.util.List;

public class Capriciosa extends Pizza {
    public Capriciosa(float price, List<Ingredients> ingredients) {
        super(price, "Capriciosa", ingredients);
        if (ingredients == null) {
            getIngredients().add(Ingredients.tomato);
            getIngredients().add(Ingredients.mozzarella);
            getIngredients().add(Ingredients.ham);
            getIngredients().add(Ingredients.artichokes);
            getIngredients().add(Ingredients.mushrooms);
        }

    }
}
