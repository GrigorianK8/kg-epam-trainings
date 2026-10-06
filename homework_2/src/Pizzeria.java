import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pizzeria {
    public static void main(String[] args) {

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter customer number:");
            int customerNumber = Integer.parseInt(reader.readLine());

            Order order = new Order(customerNumber);

            System.out.println("Enter pizza name:");
            String name = reader.readLine();

            System.out.println("Enter pizza type (REGULAR/CALZONE):");
            Type type = Type.valueOf(reader.readLine().toUpperCase());

            System.out.println("Enter quantity:");
            int quantity = Integer.parseInt(reader.readLine());

            order.addPizza(name, type, quantity);
            System.out.println("Pizza added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
