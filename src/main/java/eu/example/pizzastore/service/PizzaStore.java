package eu.example.pizzastore.service;

import eu.example.pizzastore.model.Capriciosa;
import eu.example.pizzastore.model.Margherita;
import eu.example.pizzastore.model.QuatroStagioni;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.*;


public class PizzaStore {
    private static final Log log = LogFactory.getLog(PizzaStore.class);

    private final PConfiguration config;
    private int availablePlaces;
    private BlockingQueue<Order> orderLine;
    private ExecutorService pizzaiolos;

    public PizzaStore(PConfiguration config) {
        this.config = config;
        this.availablePlaces = config.getNumberOfPlaceInPizzeria();
        this.orderLine = new ArrayBlockingQueue<Order>(config.getNumberOfOrders());
        this.pizzaiolos = Executors.newFixedThreadPool(config.getNumberOfPizzaiolo());
    }

    private void fillOrderLine() {
        for (int i = 0; i < config.getNumberOfOrderForMargherita(); i++) {
            new Thread(new Customer(this, new Margherita(8.5f,null))).start();
        }
        for (int i = 0; i < config.getNumberOfOrderForCapriciosa(); i++) {
            new Thread(new Customer(this, new Capriciosa(11.5f,null))).start();
        }
        for (int i = 0; i < config.getNumberOfOrderForQuatroStagioni(); i++) {
            new Thread(new Customer(this, new QuatroStagioni(11.5f,null))).start();
        }
    }

    private void runPizzaiolos() {
        for (int i = 0; i < config.getNumberOfPizzaiolo(); i++) {
            pizzaiolos.submit(new Pizzaiolo(orderLine));
        }
    }

    public boolean registerOrder(Order order) {
        if (availablePlaces == 0) {
            log.info("!!! Pizzeria is full!");
            return false;
        } else {
            availablePlaces--;
            orderLine.add(order);
            return true;
        }
    }

    public void perform() {
        fillOrderLine();
        runPizzaiolos();
        while (!orderLine.isEmpty()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }

        pizzaiolos.shutdown();
        // Disable new tasks from being submitted
        // Wait a while for existing tasks to terminate
        try {
            if (!pizzaiolos.awaitTermination(5000, TimeUnit.SECONDS)) {
                pizzaiolos.shutdownNow();
                // Cancel currently executing tasks
            }
        } catch (final InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pizzaiolos.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    public void exitCustomer() {
        availablePlaces++;
    }
}