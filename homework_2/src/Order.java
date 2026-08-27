import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter;

    private int orderNumber;
    private int customerNumber;
    private List<Pizza> pizzas;
    private LocalTime orderTime;

    public Order(int customerNumber) {
        this.customerNumber = customerNumber;
        pizzas = new ArrayList<>();
        this.orderNumber = 1000 + (++counter);
        this.orderTime = LocalTime.now();
    }

    public Pizza addPizza(String name, Type type, int quantity) {
        if (pizzas.size() >= 10) {
            System.out.println("Cannot add more pizzas. Order is full.");
            return null;
        }

        int index = pizzas.size() + 1;

        if (!isValidName(name)) {
            name = customerNumber + "_" + index;
        }

        Pizza pizza = new Pizza(name, type, quantity);
        pizzas.add(pizza);
        return pizza;
    }

    public void printCheck() {

        try (PrintWriter writer = new PrintWriter(new FileWriter("receipt.txt"))) {
            double total = 0;

            writer.println("********************************");
            writer.println("Order: " + orderNumber);
            writer.println("Client: " + customerNumber);

            for (Pizza pizza : pizzas) {

                writer.println("--------------------------------");
                writer.println("Name: " + pizza.getName());

                double pizzaPrice = 0;

                // base price
                if (pizza.getType() == Type.REGULAR) {
                    pizzaPrice += 1.0;
                } else {
                    pizzaPrice += 1.5;
                }

                writer.println("Pizza Base: " + pizzaPrice);

                // ingredients
                for (Ingredient ing : pizza.getIngredients()) {
                    writer.println(ing + " " + ing.getPrice());
                    pizzaPrice += ing.getPrice();
                }

                pizzaPrice *= pizza.getQuantity();

                writer.println("--------------------------------");
                writer.println("Amount: " + pizzaPrice);
                writer.println("Quantity: " + pizza.getQuantity());

                total += pizzaPrice;
            }

            writer.println("--------------------------------");
            writer.println("Total amount: " + total);
            writer.println("********************************");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidName(String name) {
        return name != null
                && name.length() >= 4
                && name.length() <= 20
                && name.matches("[a-zA-Z]+");
    }
}
