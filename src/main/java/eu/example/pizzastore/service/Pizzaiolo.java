package eu.example.pizzastore.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Pizzaiolo implements Runnable {
    private static final Log log = LogFactory.getLog(Pizzaiolo.class);

    public final static long PREPARATION_TIME = 500;
    private final String id;
    private final BlockingQueue<Order> orderLine;

    public Pizzaiolo(BlockingQueue<Order> orderLine) {
        this.id = UUID.randomUUID().toString();
        this.orderLine = orderLine;
    }

    @Override
    public void run() {
        Order order = orderLine.poll();
        while (true) {
            if(order!=null)
                preparePizza(order);
            try {
                order = orderLine.poll(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }

    public void preparePizza(Order order) {
        try {
            Thread.sleep(PREPARATION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        order.setPizzaReady(true);
        log.info("# " + order.getPizzaId() + " - " + order.getPizza() + " by " + this.id + " is ready");
    }
}