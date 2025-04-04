package eu.example.pizzastore.model;

import java.util.List;

public class QuatroStagioni extends Pizza {
    public QuatroStagioni(float price, List<Ingredients> ingredients) {
        super(price, "QuatroStagioni", ingredients);
        if(ingredients == null ) {
            getIngredients().add(Ingredients.tomato);
            getIngredients().add(Ingredients.mozzarella);
            getIngredients().add(Ingredients.ham);
            getIngredients().add(Ingredients.artichokes);
            getIngredients().add(Ingredients.anchovies);
        }

    }

}
