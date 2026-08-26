public class DynamicArrayDemo {
    public static void main(String[] args) {

        DynamicArray array = new DynamicArray();

        System.out.println("===== Empty Array =====");
        System.out.println(array);
        System.out.println("Size: " + array.size());
        System.out.println("Is empty: " + array.isEmpty());

        System.out.println("\n===== Add Elements =====");
        array.add("Java");
        array.add("Python");
        array.add("C++");

        System.out.println(array);
        System.out.println("Size: " + array.size());

        System.out.println("\n===== Get =====");
        System.out.println("Element at index 1: " + array.get(1));

        System.out.println("\n===== Set =====");
        array.set(1, "JavaScript");
        System.out.println(array);

        System.out.println("\n===== Add By Index =====");
        array.add(1, "C#");
        System.out.println(array);

        System.out.println("\n===== Remove =====");
        Object removed = array.remove(2);
        System.out.println("Removed element: " + removed);
        System.out.println(array);

        System.out.println("\n===== Contains =====");
        System.out.println("Contains Java: " + array.contains("Java"));
        System.out.println("Contains Kotlin: " + array.contains("Kotlin"));

        System.out.println("\n===== Index Of =====");
        System.out.println("Index of Java: " + array.indexOf("Java"));
        System.out.println("Index of C++: " + array.indexOf("C++"));
        System.out.println("Index of Kotlin: " + array.indexOf("Kotlin"));

        System.out.println("\n===== Clear =====");
        array.clear();
        System.out.println(array);
        System.out.println("Size: " + array.size());
        System.out.println("Is empty: " + array.isEmpty());

        System.out.println("\n===== Grow Test =====");

        DynamicArray numbers = new DynamicArray(2);

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);
        System.out.println("Size: " + numbers.size());

        System.out.println("\n===== Exception Test =====");

        try {
            numbers.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("get() works correctly: " + e);
        }

        try {
            numbers.set(-1, 5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("set() works correctly: " + e);
        }

        try {
            numbers.remove(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("remove() works correctly: " + e);
        }
    }
}
