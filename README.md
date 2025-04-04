
# 🍕 Pizzeria Threads

## Overview

The task is to implement a **Pizzeria** application in Java.

You need to complete the implementation of `Pizzeria.java`, respecting the following requirements.

## Requirements

### Pizzas & Ingredients

Each **pizzaiolo** can prepare 3 kinds of pizzas:

| Pizza Name           | Price  | Ingredients                                 |
|----------------------|--------|--------------------------------------------|
| Margherita           | 8,50€  | Tomato, Mozzarella                         |
| Capriciosa           | 11,50€ | Tomato, Mozzarella, Ham, Artichokes, Mushrooms |
| Quattro Stagioni     | 11,50€ | Tomato, Mozzarella, Ham, Mushrooms, Artichokes, Anchovies |

- Each pizza has:
    - A price
    - A list of ingredients

### Parameters

The application accepts a set of parameters:

```json
{
  "number_of_pizzaiolo": 3,
  "number_of_place_in_the_pizzeria": 50,
  "number_of_order_for_margherita": 25,
  "number_of_order_for_capriciosa": 25,
  "number_of_order_for_quatro_stagioni": 25
}
```

### Functionalities

- 🍕 A pizzaiolo prepares a pizza in **0.5 seconds**
- 🍽️ A customer eats a pizza in **1 second**
- ✅ When a customer finishes eating, they free the place for a new customer
- 🚀 The design should be flexible for adding **new types of pizza** in the future, with unknown ingredients

## Console Output Requirements

During execution, your application should print:

- When a pizza is ready:
  ```
  # pizza_id - kind_of_pizza prepared by pizzaiolo_id is ready
  ```

- When a customer starts eating:
  ```
  - customer_id starts to eat the pizza pizza_id
  ```

- When a customer finishes eating:
  ```
  - customer_id finished to eat the pizza pizza_id
  ```

- When the pizzeria is full:
  ```
  !!! The Pizzeria is full
  ```