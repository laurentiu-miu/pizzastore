package eu.example.pizzastore.service;

import eu.example.pizzastore.model.Pizza;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.UUID;

public class Customer implements Runnable {
    private static final Log log = LogFactory.getLog(Pizzaiolo.class);

    public final static int EATING_TIME = 1000;
    private final PizzaStore pizzeria;
    private final Pizza type;
    private final String id;
    private Order order;

    public Customer(PizzaStore pizzeria, Pizza type) {
        this.pizzeria = pizzeria;
        this.type = type;
        this.id = UUID.randomUUID().toString();
    }

    public void run() {
        orderPizza();
        while (!order.isPizzaReady()) {
            try {
                //System.out.println(Thread.currentThread().getName());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        eat();
    }

    public void orderPizza() {
        this.order = new Order(type);
        while (!pizzeria.registerOrder(order)) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }

    public void eat() {
        log.info(" - " + id + " starts to eat the pizza " + order.getPizzaId());
        try {
            Thread.sleep(EATING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        log.info(" - " + id + " finished to eat the pizza " + order.getPizzaId());
        pizzeria.exitCustomer();
    }
}
