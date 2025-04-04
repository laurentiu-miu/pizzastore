package eu.example.pizzastore.service;


public class PConfiguration {
    private int numberOfPizzaiolo;
    private int numberOfPlaceInPizzeria;
    private int numberOfOrderForMargherita;
    private int numberOfOrderForCapriciosa;
    private int numberOfOrderForQuatroStagioni;

    public int getNumberOfPizzaiolo() {
        return numberOfPizzaiolo;
    }

    public void setNumberOfPizzaiolo(int numberOfPizzaiolo) {
        this.numberOfPizzaiolo = numberOfPizzaiolo;
    }

    public int getNumberOfPlaceInPizzeria() {
        return numberOfPlaceInPizzeria;
    }

    public void setNumberOfPlaceInPizzeria(int numberOfPlaceInPizzeria) {
        this.numberOfPlaceInPizzeria = numberOfPlaceInPizzeria;
    }

    public int getNumberOfOrderForMargherita() {
        return numberOfOrderForMargherita;
    }

    public void setNumberOfOrderForMargherita(int numberOfOrderForMargherita) {
        this.numberOfOrderForMargherita = numberOfOrderForMargherita;
    }

    public int getNumberOfOrderForCapriciosa() {
        return numberOfOrderForCapriciosa;
    }

    public void setNumberOfOrderForCapriciosa(int numberOfOrderForCapriciosa) {
        this.numberOfOrderForCapriciosa = numberOfOrderForCapriciosa;
    }

    public int getNumberOfOrderForQuatroStagioni() {
        return numberOfOrderForQuatroStagioni;
    }

    public void setNumberOfOrderForQuatroStagioni(int numberOfOrderForQuatroStagioni) {
        this.numberOfOrderForQuatroStagioni = numberOfOrderForQuatroStagioni;
    }

    public int getNumberOfOrders() {
        return numberOfOrderForMargherita + numberOfOrderForCapriciosa + numberOfOrderForQuatroStagioni;
    }
}
