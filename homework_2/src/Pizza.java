import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Type type;
    private List<Ingredient> ingredients = new ArrayList<>();
    private int quantity;

    public Pizza(String name, Type type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            System.out.println("already exist!");
        } else if (ingredients.size() >= 7) {
            System.out.println("pizza is full!");
        } else {
            ingredients.add(ingredient);
        }
    }
}
