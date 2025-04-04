package eu.example.pizzastore;

import eu.example.pizzastore.service.PConfiguration;
import eu.example.pizzastore.service.PizzaStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzastoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PizzastoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PConfiguration conf = new PConfiguration();
		conf.setNumberOfPizzaiolo(2);
		conf.setNumberOfPlaceInPizzeria(4);
		conf.setNumberOfOrderForMargherita(6);
		conf.setNumberOfOrderForCapriciosa(6);
		conf.setNumberOfOrderForQuatroStagioni(6);
		PizzaStore pizzeria = new PizzaStore(conf);
		pizzeria.perform();
	}
}
