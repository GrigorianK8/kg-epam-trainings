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

    public void addPizza(String name, Type type, int quantity) {
        if (pizzas.size() >= 10) {
            System.out.println("Cannot add more pizzas. Order is full.");
            return;
        }

        int index = pizzas.size() + 1;

        if (!isValidName(name)) {
            name = customerNumber + "_" + index;
        }

        Pizza pizza = new Pizza(name, type, quantity);
        pizzas.add(pizza);
    }

    public void printCheck() {

        double total = 0;

        System.out.println("********************************");
        System.out.println("Order: " + orderNumber);
        System.out.println("Client: " + customerNumber);

        for (Pizza pizza : pizzas) {

            System.out.println("--------------------------------");
            System.out.println("Name: " + pizza.getName());

            double pizzaPrice = 0;

            // base price
            if (pizza.getType() == Type.REGULAR) {
                pizzaPrice += 1.0;
            } else {
                pizzaPrice += 1.5;
            }

            System.out.println("Pizza Base: " + pizzaPrice);

            // ingredients
            for (Ingredient ing : pizza.getIngredients()) {
                System.out.println(ing + " " + ing.getPrice());
                pizzaPrice += ing.getPrice();
            }

            pizzaPrice *= pizza.getQuantity();

            System.out.println("--------------------------------");
            System.out.println("Amount: " + pizzaPrice);
            System.out.println("Quantity: " + pizza.getQuantity());

            total += pizzaPrice;
        }

        System.out.println("--------------------------------");
        System.out.println("Total amount: " + total);
        System.out.println("********************************");
    }

    private boolean isValidName(String name) {
        return name != null
                && name.length() >= 4
                && name.length() <= 20
                && name.matches("[a-zA-Z]+");
    }
}
